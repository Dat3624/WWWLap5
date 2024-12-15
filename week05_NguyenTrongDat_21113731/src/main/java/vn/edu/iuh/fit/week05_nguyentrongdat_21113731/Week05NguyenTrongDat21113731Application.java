package vn.edu.iuh.fit.week05_nguyentrongdat_21113731;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.IJob;

import java.util.*;

@SpringBootApplication
public class Week05NguyenTrongDat21113731Application {

    public static void main(String[] args) {
        SpringApplication.run(Week05NguyenTrongDat21113731Application.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IJob job;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    JobSkillRepository jobSkillRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();
            //for (int i = 1; i < 1000; i++) {
//               short country= (short) CountryCode.VN.getNumeric();
//                Address add = new Address( "Quang Trung", "HCM",
//                        country,
//                        rnd.nextInt(70000, 80000) + "", CountryCode.VN.toString());
//                addressRepository.save(add);
//                Long id = ((long) i);
//                Address addnew =   addressRepository.findById(id).orElse(null);
//                Candidate can = new Candidate(
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        "email_" + i + "@gmail.com", "Name #" + i, rnd.nextLong(1111111111L, 9999999999L) + "", addnew);
//                candidateRepository.save(can);
//                System.out.println("Added: " + can);

             //}

//            for (int i = 1;i<20;i++){
//                companyRepository.save(new Company((long)i,"IT","name","123@gmail.com","1234567890","url",addressRepository.findById((long)i).orElse(null)));
//            }
//            companyRepository.findAll().forEach((company)->{
//                    for (int i = 1; i < 5; i++) {
//                    jobRepository.save(new Job( "Job Desc " + i, "Job Name " + i, company));
//                }
//
//            });
//            for (int i = 1; i < 20; i++) {
//                SkillType skillType = SkillType.values()[rnd.nextInt(SkillType.values().length)];
//                skillRepository.save(new Skill("decs" , "Skill " + i,skillType));
//            }
//            jobRepository.findAll().forEach((job)->{
//
//                for (int i = 1; i < 5; i++) {
//                    Skill skill = skillRepository.findById((long)rnd.nextInt(1, 19)).orElse(null);
//                    jobSkillRepository.save(new JobSkill(new JobSkillId(job.getId(), skill.getId()), job, "More info", SkillLevel.values()[rnd.nextInt(SkillType.values().length)]));
//                }
//            });
//            for (int i = 1; i < 50; i++) {
//                Candidate candidate = candidateRepository.findById((long) i).orElse(null);
//                if (candidate != null) {
//                    List<Long> availableSkillIds = new ArrayList<>();
//                    for (long skillId = 1; skillId <= 18; skillId++) {
//                        availableSkillIds.add(skillId);
//                    }
//                    Collections.shuffle(availableSkillIds);
//
//                    for (int j = 0; j < 2 && j < availableSkillIds.size(); j++) {
//                        Long skillId = availableSkillIds.get(j);
//
//                        CandidateSkill candidateSkill = new CandidateSkill(
//                                new CandidateSkillId( skillId,candidate.getId()),
//                                candidate,
//                                "More info",
//                                SkillLevel.values()[rnd.nextInt(SkillLevel.values().length)]
//                        );
//                        candidateSkillRepository.save(candidateSkill);
//                    }
//                }
//
//            System.out.println(skillRepository.findSkillBySkillNameIsLikeIgnoreCase("EE"));
        };
    }
}
