package use.cases.customer;

import fr.planandchill.domain.CustomerDN;
import fr.planandchill.exceptions.BusinessException;
import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateCustomerUETest {

    @Mock
    private ICustomerRepositoryPT repository;

    private CreateCustomerUE useCase;

    @Before
    public void setUp() {
        this.useCase = new CreateCustomerUE(repository);
    }

    @Test
    public void should_throw_business_exception_when_firstname_lastname_email_phone_number_password_are_null() {
        CustomerDN customerDN = new CustomerDN()
                .builder()
                .firstName(null)
                .lastName(null)
                .email(null)
                .phoneNumber(null)
                .password(null)
                .build();
        Assertions.assertThatCode(() -> {
            this.useCase.execute(customerDN);
        }).hasMessage("Le nom est obligatoire,Le prenom est obligatoire,L'email est obligatoire,Le mot de passe est obligatoire,Le numéro de téléphone est obligatoire").isInstanceOf(BusinessException.class);
    }

    @Test
    public void should_return_customer() throws BusinessException, TechnicalException {
        CustomerDN customerDN = new CustomerDN()
                .builder()
                .firstName("John")
                .lastName("Wick")
                .email("john@wick.com")
                .phoneNumber("33612345678")
                .password("!Motdepasse123")
                .build();
        CustomerDN customer = this.useCase.execute(customerDN);
        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getFirstName()).isEqualTo("John");
        Assertions.assertThat(customer.getLastName()).isEqualTo("Wick");
        Assertions.assertThat(customer.getEmail()).isEqualTo("john@wick.com");
        Assertions.assertThat(customer.getPhoneNumber()).isEqualTo("+33612345678");
    }
}