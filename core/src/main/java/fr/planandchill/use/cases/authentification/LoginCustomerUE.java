package fr.planandchill.use.cases.authentification;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginCustomerUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private ICustomerRepositoryPT repo;

    public LoginCustomerUE(ICustomerRepositoryPT repo) {
        this.repo = repo;
    }

    public Boolean execute() {
        return null;
    }

}
