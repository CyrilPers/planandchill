package fr.planandchill.rest.config.use.cases.company;

import fr.planandchill.ports.customer.ICompanyRepositoryPT;
import fr.planandchill.repositories.CompanyJpaRepository;
import fr.planandchill.use.cases.company.CreateCompanyUE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

public class CompanyUECfg {

    @Bean
    private ICompanyRepositoryPT repository() {return new CompanyJpaRepository();}

    @Bean
    @DependsOn
    public CreateCompanyUE createCompanyUE(ICompanyRepositoryPT repository) {
        return new CreateCompanyUE(repository);
    }

    @Bean
    @DependsOn(value = {"createCompanyUE"})
    public CompanyUseCases companyUseCases(CreateCompanyUE createCompanyUE) {
        CompanyUseCases useCases = CompanyUseCases.builder()
                .createCompanyUE(createCompanyUE)
                .build();
        return useCases;
    }
}
