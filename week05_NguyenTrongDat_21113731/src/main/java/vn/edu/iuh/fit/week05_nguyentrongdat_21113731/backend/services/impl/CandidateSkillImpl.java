package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkillId;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ICandidateSkill;

import java.util.List;
@Service

public class CandidateSkillImpl implements ICandidateSkill {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public List<CandidateSkill> getCandidateSkillsById_SkillId(Long skillId) {
        return candidateSkillRepository.getCandidateSkillsById_SkillId(skillId);
    }

    @Override
    public CandidateSkill findById(CandidateSkillId id) {
        return candidateSkillRepository.findById(id).orElse(null);
    }
}
