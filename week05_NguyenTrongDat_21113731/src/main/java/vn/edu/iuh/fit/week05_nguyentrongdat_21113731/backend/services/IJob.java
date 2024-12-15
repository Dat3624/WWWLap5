package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;


import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;

import java.util.List;

public interface IJob {
    public List<Job> getJobByCompanyId(Long id);
    public void addJob(Job job);
    public void deleteJob(Long id);
    public Job getJobById(Long id);


}
