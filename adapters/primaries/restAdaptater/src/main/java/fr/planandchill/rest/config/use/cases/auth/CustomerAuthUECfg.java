package fr.planandchill.rest.config.use.cases.auth;

import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.repositories.CustomerJpaRepository;
import fr.planandchill.use.cases.authentification.LoginCustomerUE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class CustomerAuthUECfg {

    @Bean
    public ICustomerRepositoryPT repository()  {return new CustomerJpaRepository();}

    @Bean
    @DependsOn
    public LoginCustomerUE customerAuthUE(ICustomerRepositoryPT repository) {
        return new LoginCustomerUE(repository);
    }

    @Bean
    @DependsOn(value = {"customerAuthentificationUE"})
    public CustomerAuthUseCases customerAuthUseCases(LoginCustomerUE loginCustomerUE) {
        CustomerAuthUseCases useCases = CustomerAuthUseCases.builder()
                .loginCustomerUE(loginCustomerUE)
                .build();
        return useCases;

    }
}
