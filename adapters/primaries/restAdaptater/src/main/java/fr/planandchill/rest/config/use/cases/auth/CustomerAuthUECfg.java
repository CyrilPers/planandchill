package fr.planandchill.rest.config.use.cases.auth;

import fr.planandchill.ports.user.IUserRepositoryPT;
import fr.planandchill.repositories.UserJpaRepository;
import fr.planandchill.use.cases.authentification.LoginCustomerUE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class CustomerAuthUECfg {

    @Bean
    public IUserRepositoryPT customerRepository() {return new UserJpaRepository();}

    @Bean
    @DependsOn
    public LoginCustomerUE customerAuthUE(IUserRepositoryPT logRepository) {
        return new LoginCustomerUE(logRepository);
    }

    @Bean
    @DependsOn(value = {"customerAuthUE"})
    public CustomerAuthUseCases customerAuthUseCases(LoginCustomerUE loginCustomerUE) {
        CustomerAuthUseCases useCases = CustomerAuthUseCases.builder()
                .loginCustomerUE(loginCustomerUE)
                .build();
        return useCases;

    }
}
