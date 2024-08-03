package fr.planandchill.rest.config.use.cases.customer;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUseCases {
    private CreateCustomerUE createCustomerUseCase;
}
