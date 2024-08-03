package fr.planandchill.use.cases.worker;

import fr.planandchill.domain.WorkerDN;
import fr.planandchill.exceptions.BusinessException;
import fr.planandchill.exceptions.TechnicalException;
import fr.planandchill.ports.auth.IAuthentificationPT;
import fr.planandchill.ports.worker.IWorkerRepositoryPT;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static fr.planandchill.utils.user.TestStringMandatory.testStringMandatory;

public class CreateWorkerUE {

    private final Logger LOG = LoggerFactory.getLogger(CreateCustomerUE.class);

    private IWorkerRepositoryPT workerRepo;

    private IAuthentificationPT auth;

    public CreateWorkerUE(IWorkerRepositoryPT workerRepo, IAuthentificationPT auth) {
        this.workerRepo = workerRepo;
        this.auth = auth;
    }

    public WorkerDN createWorker(WorkerDN workerDN) throws TechnicalException, BusinessException {
        checkBusinessRules(workerDN);
        try {
            workerDN.setCreationDate(LocalDateTime.now());
            workerDN.setPassword(auth.encode(workerDN.getPassword()));
            return workerRepo.create(workerDN);
        } catch (UnknownHostException | SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new TechnicalException(e.getMessage());
        }
    }

    private void checkBusinessRules(WorkerDN workerDN) throws TechnicalException, BusinessException {
        List<String> errorsList = new ArrayList<>();
        if (workerDN ==null)
            throw new TechnicalException("CustomerDN is null");
        testStringMandatory(errorsList, workerDN.getLastName(), "nom", 30, 2);
        testStringMandatory(errorsList, workerDN.getFirstName(), "prénom", 40, 2);
        testStringMandatory(errorsList, workerDN.getEmail(), "email", 100, 2);
        testStringMandatory(errorsList, workerDN.getPassword(), "mot de passe", 30, 8);
        testStringMandatory(errorsList, workerDN.getPhoneNumber(), "téléphone", 14, 6);
        if (!errorsList.isEmpty()) {
            throw new BusinessException(String.join(",", errorsList), errorsList);
        }
    }
}
