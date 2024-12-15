package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkillId;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    List<CandidateSkill> getCandidateSkillsById_CanId(Long canId);
    List<CandidateSkill> getCandidateSkillsById_SkillId(Long skillId);

}