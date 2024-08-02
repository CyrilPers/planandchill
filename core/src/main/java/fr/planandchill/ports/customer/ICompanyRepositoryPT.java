package fr.planandchill.ports.customer;

import fr.planandchill.domain.CompanyDN;

public interface ICompanyRepositoryPT {
    CompanyDN create(CompanyDN companyDN);
}
