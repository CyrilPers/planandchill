package fr.planandchill.use.cases.customer;

import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.models.Customer;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.exceptions.BusinessException;

import org.apache.commons.lang3.StringUtils;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCustomerUE {


    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private ICustomerRepositoryPT repo;

    public CreateCustomerUE(ICustomerRepositoryPT repo) {
        this.repo = repo;
    }

    public Customer execute(Customer customer) throws TechnicalException, BusinessException {
        checkBusinessRules(customer); // check if the customer is valid
        try {
            return repo.create(customer);
        } catch (UnknownHostException | SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new TechnicalException(e.getMessage());
        }
    }

    private void checkBusinessRules(Customer customer) throws BusinessException, TechnicalException {
        List<String> errorsList = new ArrayList<>();
        if (customer == null) {
            throw new TechnicalException("Customer is null");
        } else {
            testStringMandatory(errorsList, customer.getLastName(), "nom", 30, 2);
            testStringMandatory(errorsList, customer.getFirstName(), "prenom", 40, 2);
            testStringMandatory(errorsList, customer.getEmail(), "email", 100, 2);
            testStringMandatory(errorsList, customer.getPassword(), "mot de passe", 30, 8);
            if (!errorsList.isEmpty()) {
                throw new BusinessException(String.join(",", errorsList), errorsList);
            }
        }
    }


    private void testStringMandatory(List<String> errorsList, String str, String fieldName, int maxLength, int minLength) {
        if (StringUtils.isEmpty(str)) {
            errorsList.add("Le " + fieldName + " d'une personne est obligatoire");
        } else {
            if (str.length() > maxLength) {
                errorsList.add("Le " + fieldName + " d'une personne ne doit pas dépasser " + maxLength + " caracteres");
            }
            if (str.length() < minLength) {
                errorsList.add("Le " + fieldName + " d'une personne doit avoir au minimum " + minLength + " caracteres");
            }
            if (fieldName.equals("mot de passe")) {
                if (!Pattern.matches(".*[A-Z]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins une lettre majuscule");
                }
                if (!Pattern.matches(".*[a-z]*.+", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins une lettre minuscule");
                }
                if (!Pattern.matches(".*[0-9]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins un chiffre");
                }
                if (!Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\|,.<>/?]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit pas contenir au moins un caractère spécial");
                }
            }
        }
    }

}
