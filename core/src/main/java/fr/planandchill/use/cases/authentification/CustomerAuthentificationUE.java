package fr.planandchill.use.cases.authentification;

import fr.planandchill.domain.CustomerDN;
import fr.planandchill.exceptions.BusinessException;
import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.invoke.MethodHandles.throwException;

public class CustomerAuthentificationUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private PasswordEncoder passwordEncoder;

    private ICustomerRepositoryPT repo;

    public CustomerAuthentificationUE(ICustomerRepositoryPT repo) {
        this.repo = repo;
    }

    public CustomerDN execute(String email, String password) throws SQLException, TechnicalException {
        try {
            CustomerDN customerDN = repo.load(email);
            if (customerDN == null) {
                throw new BusinessException("Identifiants incorrects");
            }
            checkBusinessRules(password, customerDN);
            return customerDN;
        } catch (UnknownHostException | SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new TechnicalException(e.getMessage());
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkBusinessRules(String password, CustomerDN customerDN) throws BusinessException {
        if (!passwordEncoder.matches(password, customerDN.getPassword())) {
            throw new BusinessException("Mot de passe incorrect");
        }
    }

}
