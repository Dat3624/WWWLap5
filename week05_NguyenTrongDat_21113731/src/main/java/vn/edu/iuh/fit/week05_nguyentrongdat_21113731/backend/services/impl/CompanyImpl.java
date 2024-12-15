package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Company;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ICompany;

@Service
public class CompanyImpl implements ICompany {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return companyRepository.existsById(id);
    }
}
