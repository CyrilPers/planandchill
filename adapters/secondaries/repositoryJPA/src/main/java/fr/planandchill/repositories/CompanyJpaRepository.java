package fr.planandchill.repositories;

import fr.planandchill.domain.CompanyDN;
import fr.planandchill.domain.WorkerDN;
import fr.planandchill.entities.Company;
import fr.planandchill.entities.Worker;
import fr.planandchill.ports.company.ICompanyRepositoryPT;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class CompanyJpaRepository implements ICompanyRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public WorkerDN create(WorkerDN workerDN) {
        CompanyDN companyDN = workerDN.getCompanies().get(0);
        Company company = new Company().builder()
                .name(companyDN.getName())
                .description(companyDN.getDescription())
                .siret(companyDN.getSiret())
                .adminLink(companyDN.getAdminLink())
                .build();
        Worker worker = new Worker();
        worker.setCompany(company);
        worker.setFirstName(workerDN.getFirstName());
        worker.setLastName(workerDN.getLastName());
        worker.setEmail(workerDN.getEmail());
        worker.setPassword(workerDN.getPassword());
        worker.setPhoneNumber(workerDN.getPhoneNumber());
        worker.setCreationDate(LocalDateTime.now());

        try {
            em.persist(worker);
            workerDN.setId(worker.getId());
            return workerDN;
        } catch (Exception e) {
            LOG.error("Error while persisting companyDN ", e);
            throw new RuntimeException(e);
        }
    }
}
