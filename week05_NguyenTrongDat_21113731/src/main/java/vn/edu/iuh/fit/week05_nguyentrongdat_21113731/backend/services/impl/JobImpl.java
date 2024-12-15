package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.JobRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.IJob;

import java.util.List;
@Service
public class JobImpl implements IJob {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> getJobByCompanyId(Long id) {
        return jobRepository.getJobsByCompanyId(id);
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }
    @Transactional
    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

}
