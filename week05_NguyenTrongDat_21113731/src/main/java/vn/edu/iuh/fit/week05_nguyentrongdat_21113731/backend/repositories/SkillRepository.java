package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Skill;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findSkillBySkillNameIsLikeIgnoreCase(String name);


}