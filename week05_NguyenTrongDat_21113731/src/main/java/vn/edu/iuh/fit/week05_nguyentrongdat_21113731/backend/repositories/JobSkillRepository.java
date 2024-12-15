package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkillId;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    List<JobSkill> findJobSkillsByJob(Job job);
    List<JobSkill> findJobSkillsById_JobId(Long jobId);

    List<JobSkill> findJobSkillsById_SkillId(Long skillId);
    void deleteJobSkillsById_JobId(Long jobId);

}