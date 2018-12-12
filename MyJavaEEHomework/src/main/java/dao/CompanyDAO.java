package dao;

import model.Company;

public interface CompanyDAO {

    void createCompany(Company company);

    Company getCompanyById(int id);

    boolean updateCompany(Company company);

    boolean deleteCompany(Company company);
}
