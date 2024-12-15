package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;


import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Candidate;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;

import java.util.List;

public interface ICandidate {
    public Candidate getCandidateById(Long id);
    boolean existsById(Long id);
    List<CandidateSkill> getCandidateSkillsById_CanId(Long canId);


}
