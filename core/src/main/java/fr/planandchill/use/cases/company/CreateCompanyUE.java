package fr.planandchill.use.cases.company;

import fr.planandchill.ports.customer.ICompanyRepositoryPT;


public class CreateCompanyUE {

    private ICompanyRepositoryPT repo;

    public CreateCompanyUE(ICompanyRepositoryPT repo) {
        this.repo = repo;
    }



}
