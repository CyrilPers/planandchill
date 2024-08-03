package fr.planandchill.rest.config.use.cases.customer;

import fr.planandchill.authentification.AuthUtils;
import fr.planandchill.ports.auth.IAuthentificationPT;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.repositories.CustomerJpaRepository;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class CustomerUECfg {

    @Bean
    protected ICustomerRepositoryPT customerRepository()  {return new CustomerJpaRepository();}

    @Bean
    protected IAuthentificationPT auth(){return new AuthUtils();}

    @Bean
    @DependsOn
    public CreateCustomerUE createCustomerUE(ICustomerRepositoryPT repository, IAuthentificationPT auth) {
        return new CreateCustomerUE(repository, auth);
    }

    @Bean
    @DependsOn(value = {"createCustomerUE"})
    public CustomerUseCases customerUseCases(CreateCustomerUE createCustomerUE) {
        CustomerUseCases useCases = CustomerUseCases.builder()
                .createCustomerUseCase(createCustomerUE)
                .build();
        return useCases;

    }
}
