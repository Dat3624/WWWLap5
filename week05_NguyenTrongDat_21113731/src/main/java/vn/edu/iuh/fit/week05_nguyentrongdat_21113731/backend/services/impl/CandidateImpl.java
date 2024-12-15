package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Candidate;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ICandidate;

import java.util.List;

@Service
public class CandidateImpl implements ICandidate {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return candidateRepository.existsById(id);
    }

    @Override
    public List<CandidateSkill> getCandidateSkillsById_CanId(Long canId) {
        return candidateSkillRepository.getCandidateSkillsById_CanId(canId);
    }
}
