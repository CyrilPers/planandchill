package fr.planandchill.use.cases.company;

import fr.planandchill.domain.CompanyDN;
import fr.planandchill.domain.WorkerDN;
import fr.planandchill.exceptions.BusinessException;
import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.ports.company.ICompanyRepositoryPT;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class CreateCompanyUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCompanyUE.class);

    private ICompanyRepositoryPT companyRepo;


    public CreateCompanyUE(ICompanyRepositoryPT companyRepo) {
        this.companyRepo = companyRepo;
    }

    public WorkerDN execute(WorkerDN workerDN) throws TechnicalException, BusinessException {
        checkBusinessRules(workerDN.getCompanies().get(0));
        return companyRepo.create(workerDN);
    }

    private void checkBusinessRules(CompanyDN companyDN) throws TechnicalException, BusinessException {
        List<String> errorsList = new ArrayList<>();
        if (companyDN == null) {
            throw new TechnicalException("CompanyDN is null");
        } else {
            testStringMandatory(errorsList, companyDN.getName(), "nom", 50, 2);
            testStringMandatory(errorsList, companyDN.getDescription(), "description", 250, 2);
            testStringMandatory(errorsList, companyDN.getSiret().toString(), "siret", 14, 2);
            testStringMandatory(errorsList, companyDN.getAdminLink(), "adminLink", 50, 2);
            if (!errorsList.isEmpty()) {
                throw new BusinessException(String.join(",", errorsList), errorsList);
            }
        }

    }

    private void testStringMandatory(List<String> errorsList, String str, String fieldName, int maxLength, int minLength) {
        String startWord = getStartWord(fieldName);
        if (StringUtils.isEmpty(str)) {
            errorsList.add(startWord + fieldName + " est obligatoire");
        } else {
            if (str.length() > maxLength) {
                errorsList.add(startWord + fieldName + " ne doit pas dépasser " + maxLength + " caracteres");
            }
            if (str.length() < minLength) {
                errorsList.add(startWord + fieldName + " doit avoir au minimum " + minLength + " caracteres");
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
