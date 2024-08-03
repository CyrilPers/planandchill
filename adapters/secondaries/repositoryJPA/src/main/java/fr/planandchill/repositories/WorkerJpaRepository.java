package fr.planandchill.repositories;

import fr.planandchill.domain.WorkerDN;
import fr.planandchill.entities.Company;
import fr.planandchill.entities.Worker;
import fr.planandchill.ports.worker.IWorkerRepositoryPT;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.sql.SQLException;

public class WorkerJpaRepository implements IWorkerRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public WorkerDN create(WorkerDN workerDN) throws UnknownHostException, SQLException {
        Company company = new Company();
        company.setId(workerDN.getCompanies().get(0).getId());
        Worker worker = new Worker();
        worker.setFirstName(workerDN.getFirstName());
        worker.setLastName(workerDN.getLastName());
        worker.setEmail(workerDN.getEmail());
        worker.setPassword(workerDN.getPassword());
        worker.setPhoneNumber(workerDN.getPhoneNumber());
        worker.setCreationDate(workerDN.getCreationDate());
        worker.setCompany(company);
        try {
            em.persist(worker);
            workerDN.setId(worker.getId());
            return workerDN;
        } catch (PersistenceException e) {
            LOG.error("Error while persisting worker ", e);
            throw new SQLException("Error while persisting worker ");
        }
    }
}
