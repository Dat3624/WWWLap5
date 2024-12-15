package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;

import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkillId;

import java.util.List;

public interface IJobSkill {
    void addJobSkill(JobSkill jobSkill);
    void deleteJobSkillsById_JobId(Long id);
    List<JobSkill> findJobSkillsById_JobId(Long jobId);
    List<JobSkill> findJobSkillsById_SkillId(Long skillId);
    JobSkill findJobSkillById(JobSkillId id);
}
