package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.CandidateDto;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.JobDto;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home/candidate")

public class CandidateController {
    private Candidate candidate;
    @Autowired
    private ICandidate iCandidate;
    @Autowired
    private IJobSkill iJobSkill;
    @Autowired
    private IJob iJob;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ISkill iSkill;
    @Autowired
    private ICompany iCompany;
    @Autowired
    private JavaMailSender emailSender;
    private Company company;
    private Boolean companyFlag = true;
    @GetMapping
    public String showCandidate(@RequestParam("id") Long id, Model model){
        candidate = iCandidate.getCandidateById(id);
        ArrayList<Skill> listSkillNeedAdd = new ArrayList<>();
        model.addAttribute("company", companyFlag ?null:company);
        companyFlag = true;
        Map<Long,Integer> listJob = new LinkedHashMap<>();
        iCandidate.getCandidateSkillsById_CanId(id).forEach(candidateSkill ->{
            iJobSkill.findJobSkillsById_SkillId(candidateSkill.getId().getSkillId()).forEach(jobSkill -> {
                if(listJob.containsKey(jobSkill.getId().getJobId())){
                    listJob.put(jobSkill.getId().getJobId(), listJob.get(jobSkill.getId().getJobId())+1);
                }else{
                    listJob.put(jobSkill.getId().getJobId(),1);
                }
            });
        });
        Map<Long,Integer> listJobSort = listJob.entrySet()
                .stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        ArrayList<Long> listJobId = new ArrayList<>(listJobSort.keySet());
        List<Job> jobs = listJobId.stream().map(iJob::getJobById).toList();
        List<JobDto> jobDtos= jobs.stream().map((element) -> modelMapper.map(element, JobDto.class)).toList();
        jobDtos.forEach(jobDto -> {

            jobDto.setSkills(iSkill.getSkillsByJobId(jobDto.getId()));
            List<String> skillString = new ArrayList<>();
            jobDto.getSkills().forEach(skill ->{
                iCandidate.getCandidateSkillsById_CanId(candidate.getId()).forEach(candidateSkill -> {
                    if(candidateSkill.getId().getSkillId().equals(skill.getId())) {
                        skillString.add("*");
                    }

                });
                if(skillString.isEmpty()) {
                    listSkillNeedAdd.add(skill);
                }
                skillString.add(skill.getSkillName()+"("+iJobSkill.findJobSkillById(new JobSkillId(jobDto.getId(),skill.getId())).getSkillLevel()+")");
            });
            jobDto.setSkillString(String.join(", ",skillString));
            jobDto.setSkillString(jobDto.getSkillString().replace("*, ","*"));
        });
        Map<String, List<CandidateSkill>> candidateSkillsByType = iCandidate.getCandidateSkillsById_CanId(id).stream()
                .collect(Collectors.groupingBy(candidateSkill -> candidateSkill.getSkill().getType().name()));

        Map<Skill,Integer> skillCount = new HashMap<>();
        for (Skill skill : listSkillNeedAdd) {
            if(skillCount.containsKey(skill)){
                skillCount.put(skill, skillCount.get(skill)+1);
            }else{
                skillCount.put(skill,1);
            }
        }
        for (Map.Entry<Skill,Integer> entry : skillCount.entrySet()) {
            System.out.println(entry.getKey().getSkillName() + " " + entry.getValue());
        }
        Map<Skill,Integer> listSkillSort =  skillCount.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)// Sắp xếp giảm dần
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Giải quyết xung đột
                        LinkedHashMap::new // Giữ thứ tự sắp xếp
                ));

        model.addAttribute("listSkillSort",listSkillSort);

        model.addAttribute("skillsByType", candidateSkillsByType);

        model.addAttribute("jobsSort",jobDtos);
        model.addAttribute("candidate",candidate);
        return "home/candidate";
    }

    @GetMapping("/infoCompany")
    public String getCompanyInfo(@RequestParam Long id, Model model) {
         company = iCompany.getCompanyById(id);
         companyFlag = false;
        model.addAttribute("company", company);
        return "redirect:/home/candidate?id="+candidate.getId();
    }
    @GetMapping("/sendEmail")
    public String sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("trongdat1822@gmail.com");
        message.setSubject("Apply job");
        message.setText("");
        this.emailSender.send(message);
        return "redirect:/home/candidate?id="+candidate.getId();
    }



}
