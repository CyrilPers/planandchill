package fr.planandchill.rest.config.use.cases.customer;

import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import fr.planandchill.repositories.CustomerJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class CustomerUECfg {

    @Bean
    public ICustomerRepositoryPT icustomerRepositoryPT() {
        return new CustomerJpaRepository();
    }

    @Bean
    @DependsOn
    public CreateCustomerUE createCustomerUE(ICustomerRepositoryPT repository) {
        return new CreateCustomerUE(repository);
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
