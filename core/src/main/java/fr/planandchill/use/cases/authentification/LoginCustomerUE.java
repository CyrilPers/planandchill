package fr.planandchill.use.cases.authentification;
import fr.planandchill.domain.UserDN;
import fr.planandchill.ports.customer.IUserRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.sql.SQLException;

public class LoginCustomerUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private IUserRepositoryPT repo;

    public LoginCustomerUE(IUserRepositoryPT repo) {
        this.repo = repo;
    }

    public UserDN execute(String email) throws UnknownHostException, SQLException {
        UserDN user = this.repo.findByEmail(email);
        return user;
    }
}
