package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> getJobsByCompanyId(Long id);

}