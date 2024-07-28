package fr.planandchill.use.cases.customer;

import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.models.CustomerDN;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import fr.planandchill.exceptions.BusinessException;

import org.apache.commons.lang3.StringUtils;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

    public CustomerDN execute(CustomerDN customerDN) throws TechnicalException, BusinessException {
        customerDN.setCreationDate(LocalDateTime.now());
        checkBusinessRules(customerDN); // check if the customerDN is valid
        try {
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
            testStringMandatory(errorsList, customerDN.getFirstName(), "prenom", 40, 2);
            testStringMandatory(errorsList, customerDN.getEmail(), "email", 100, 2);
            testStringMandatory(errorsList, customerDN.getPassword(), "mot de passe", 30, 8);
            if (!errorsList.isEmpty()) {
                throw new BusinessException(String.join(",", errorsList), errorsList);
            }
        }
    }


    private void testStringMandatory(List<String> errorsList, String str, String fieldName, int maxLength, int minLength) {
        String startWord = getStartWord(fieldName);
        if (StringUtils.isEmpty(str)) {
            errorsList.add(startWord + fieldName + " d'une personne est obligatoire");
        } else {
            if (str.length() > maxLength) {
                errorsList.add(startWord + fieldName + " d'une personne ne doit pas dépasser " + maxLength + " caracteres");
            }
            if (str.length() < minLength) {
                errorsList.add(startWord + fieldName + " d'une personne doit avoir au minimum " + minLength + " caracteres");
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

    private String getStartWord(String fieldName) {
        return fieldName.equals("email") ? "L'" : "Le ";
    }

}
