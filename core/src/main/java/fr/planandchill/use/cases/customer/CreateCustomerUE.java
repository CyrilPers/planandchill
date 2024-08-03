package fr.planandchill.use.cases.customer;

import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.domain.CustomerDN;
import fr.planandchill.ports.auth.IAuthentificationPT;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.exceptions.BusinessException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static fr.planandchill.utils.user.TestStringMandatory.testStringMandatory;

public class CreateCustomerUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private ICustomerRepositoryPT repo;

    private IAuthentificationPT auth;


    public CreateCustomerUE(ICustomerRepositoryPT repo, IAuthentificationPT auth) {
        this.repo = repo;
        this.auth = auth;
    }

    public CustomerDN execute(CustomerDN customerDN) throws TechnicalException, BusinessException {
        checkBusinessRules(customerDN);
        try {

            customerDN.setCreationDate(LocalDateTime.now());
            customerDN.setPassword(auth.encode(customerDN.getPassword()));
            return repo.create(customerDN);
        } catch (UnknownHostException | SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new TechnicalException(e.getMessage());
        }
    }

    private void checkBusinessRules(CustomerDN customerDN) throws BusinessException, TechnicalException {
        List<String> errorsList = new ArrayList<>();
        if (customerDN == null) {
            throw new TechnicalException("CustomerDN is null");
        } else {
            testStringMandatory(errorsList, customerDN.getLastName(), "nom", 30, 2);
            testStringMandatory(errorsList, customerDN.getFirstName(), "prénom", 40, 2);
            testStringMandatory(errorsList, customerDN.getEmail(), "email", 100, 2);
            testStringMandatory(errorsList, customerDN.getPassword(), "mot de passe", 30, 8);
            testStringMandatory(errorsList, customerDN.getPhoneNumber(), "téléphone", 14, 6);
            if (!errorsList.isEmpty()) {
                throw new BusinessException(String.join(",", errorsList), errorsList);
            }
        }
    }
}
