package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services;

import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Company;

public interface ICompany {
    public Company getCompanyById(Long id);
    public boolean existsById(Long id);
}
