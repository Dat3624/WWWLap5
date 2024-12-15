package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;

import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkillId;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.CandidateDto;

import java.util.List;

public interface ICandidateSkill {
    List<CandidateSkill> getCandidateSkillsById_SkillId(Long skillId);
    CandidateSkill findById(CandidateSkillId id);
}
