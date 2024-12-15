package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.CandidateDto;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.JobDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home/company")
public class CompanyController {
    @Autowired
    private IJob iJob;
    @Autowired
    private ISkill iSkill;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICompany companyService;
    @Autowired
    private IJobSkill iJobSkill;
    @Autowired
    private ICandidate iCandidate;
    @Autowired
    private ICandidateSkill iCandidateSkill;
    private String idCompany;
    private Company company;
    @GetMapping
    public String getInforCompany(Model model, @RequestParam("id") Long id){
        idCompany = id.toString();
        company = companyService.getCompanyById(id);
    model.addAttribute("company",company);
    model.addAttribute("listSkill",iSkill.getAllSkills());

    List<JobDto> jobDtos = iJob.getJobByCompanyId(id).stream().map((element) -> modelMapper.map(element, JobDto.class)).toList();
    jobDtos.forEach(jobDto -> {
        jobDto.setSkills(iSkill.getSkillsByJobId(jobDto.getId()));
    });
    model.addAttribute("jobDto",new JobDto());
    model.addAttribute("jobsByCompany",jobDtos);
    return "home/company";
    }
    @PostMapping("/addJob")
    public String addJob(@ModelAttribute JobDto jobDto, Model model){
        String[] listSkill = jobDto.getSkillString().split(",");
        Job job = new Job();
        job.setJobName(jobDto.getJobName());
        job.setCompany(company);

        if (jobDto.getJobDesc()!=null&&!jobDto.getJobDesc().isEmpty()){
            job.setJobDesc(jobDto.getJobDesc());
        }else {
            job.setJobDesc("trong");
        }
        iJob.addJob(job);
        for (int i=0;i<listSkill.length;i++){
            String[] skillName = listSkill[i].split("\\(");
            int startIndex = listSkill[i].indexOf("(");
            int endIndex = listSkill[i].indexOf(")");

            String skillLevel = listSkill[i].substring(startIndex+1,endIndex);
            Skill skill= iSkill.getSkillByName(skillName[0]);
            iJobSkill.addJobSkill(new JobSkill(new JobSkillId(job.getId(), skill.getId()),job,skill,"",SkillLevel.valueOf(skillLevel.toUpperCase())));
        }


        return "redirect:/home/company?id="+idCompany;
    }
    @PostMapping("/deleteJob")
    public String deleteJob(@RequestParam("id")Long id){
        iJobSkill.deleteJobSkillsById_JobId(id);
        iJob.deleteJob(id);

        return "redirect:/home/company?id="+idCompany;
    }
    @GetMapping("/suggest/{id}")
    public String suggestCandidate(@PathVariable(name = "id") Long id, Model model){
        Map<Long,Integer> listCandidate = new LinkedHashMap<>();
        iJobSkill.findJobSkillsById_JobId(id).forEach(jobSkill -> {
            iCandidateSkill.getCandidateSkillsById_SkillId(jobSkill.getId().getSkillId()).forEach(candidateSkill -> {
                if(listCandidate.containsKey(candidateSkill.getId().getCanId())){
                    listCandidate.put(candidateSkill.getId().getCanId(), listCandidate.get(candidateSkill.getId().getCanId())+1);
                }else{
                    listCandidate.put(candidateSkill.getId().getCanId(),1);
                }
            });
        });
        Map<Long,Integer> listCandidateSort= listCandidate.entrySet()
                .stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        ArrayList<Long> listCandidateId = new ArrayList<>(listCandidateSort.keySet());
        List<Candidate> candidates = listCandidateId.stream().map(iCandidate::getCandidateById).toList();
        List<CandidateDto> candidateDtos= candidates.stream().map((element) -> modelMapper.map(element, CandidateDto.class)).toList();
        candidateDtos.forEach(candidateDto -> {

            candidateDto.setSkills(iSkill.getSkillsByCandidateId(candidateDto.getId()));
            List<String> skillString = new ArrayList<>();
            candidateDto.getSkills().forEach(skill ->{
                iJobSkill.findJobSkillsById_JobId(id).forEach(jobSkill -> {
                    if(jobSkill.getId().getSkillId().equals(skill.getId()))
                        skillString.add("*");
                });
                skillString.add(skill.getSkillName()+"("+iCandidateSkill.findById(new CandidateSkillId(candidateDto.getId(),skill.getId())).getSkillLevel()+")");
            });
            candidateDto.setSkillString(String.join(", ",skillString));
            candidateDto.setSkillString(candidateDto.getSkillString().replace("*, ","*"));
        });

        List<CandidateDto> candidateDtoTop5 = candidateDtos.subList(0, Math.min(5, candidateDtos.size()));

        System.out.println(candidateDtos);
        model.addAttribute("candidateDtoTop5",candidateDtos);

        return "home/candidateSuggest";
    }

}
