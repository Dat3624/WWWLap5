package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;


import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Skill;

import java.util.List;

public interface ISkill {
    public void add(Skill skill);
    public void delete(Long id);
    public void update(Skill skill);
    public Skill getSkillById(Long id);
    public List<Skill> getSkillsByJobId(Long id);
    public List<Skill> getSkillsByCandidateId(Long id);
    public Skill getSkillByName(String name);
    public List<Skill> getAllSkills();
}
