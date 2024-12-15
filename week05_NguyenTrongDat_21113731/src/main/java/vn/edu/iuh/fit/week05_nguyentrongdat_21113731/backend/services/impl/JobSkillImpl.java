package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkillId;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.IJobSkill;

import java.util.List;

@Service
public class JobSkillImpl implements IJobSkill {
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Override
    public void addJobSkill(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
    }
    @Transactional
    @Override
    public void deleteJobSkillsById_JobId(Long id) {
        jobSkillRepository.deleteJobSkillsById_JobId(id);
    }

    @Override
    public List<JobSkill> findJobSkillsById_JobId(Long jobId) {
        return jobSkillRepository.findJobSkillsById_JobId(jobId);
    }

    @Override
    public List<JobSkill> findJobSkillsById_SkillId(Long skillId) {
        return jobSkillRepository.findJobSkillsById_SkillId(skillId);
    }

    @Override
    public JobSkill findJobSkillById(JobSkillId id) {
        return jobSkillRepository.findById(id).orElse(null);
    }
}
