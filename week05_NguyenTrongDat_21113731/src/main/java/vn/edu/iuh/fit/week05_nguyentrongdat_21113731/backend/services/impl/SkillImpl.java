package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Skill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ISkill;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillImpl implements ISkill {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Override
    public void add(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public void update(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> getSkillsByJobId(Long id) {

        List<JobSkill> jobSkillsByJob = jobSkillRepository.findJobSkillsById_JobId(id);
        List<Skill> skills = new ArrayList<>();
        jobSkillsByJob.forEach(jobSkill -> {
            skills.add(skillRepository.findById(jobSkill.getId().getSkillId()).orElse(null));
        });
        return skills;
    }

    @Override
    public List<Skill> getSkillsByCandidateId(Long id) {
        List<CandidateSkill> candidateSkills = candidateSkillRepository.getCandidateSkillsById_CanId(id);
        List<Skill> skills = new ArrayList<>();
        candidateSkills.forEach(candidateSkill -> {
            skills.add(skillRepository.findById(candidateSkill.getId().getSkillId()).orElse(null));
        });
        return skills;
    }

    @Override
    public Skill getSkillByName(String name) {
        return skillRepository.findSkillBySkillNameIsLikeIgnoreCase(name);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

}
