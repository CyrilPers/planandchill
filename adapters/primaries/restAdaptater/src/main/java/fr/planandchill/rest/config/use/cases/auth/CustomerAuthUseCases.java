package fr.planandchill.rest.config.use.cases.auth;
import fr.planandchill.use.cases.authentification.LoginCustomerUE;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAuthUseCases {

    private LoginCustomerUE loginCustomerUE;

}
