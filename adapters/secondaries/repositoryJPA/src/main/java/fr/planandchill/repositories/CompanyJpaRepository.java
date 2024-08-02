package fr.planandchill.repositories;

import fr.planandchill.domain.CompanyDN;
import fr.planandchill.entities.Company;
import fr.planandchill.ports.customer.ICompanyRepositoryPT;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompanyJpaRepository implements ICompanyRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public CompanyDN create(CompanyDN companyDN) {
        Company company = new Company().builder()
                .idCompany(companyDN.getId())
                .name(companyDN.getName())
                .description(companyDN.getDescription())
                .siret(companyDN.getSiret())
                .textMessageBalance(companyDN.getTextMessageBalance())
                .adminLink(companyDN.getAdminLink())
                .build();
        try {
            em.persist(company);
            return companyDN;
        } catch (Exception e) {
            LOG.error("Error while persisting companyDN ", e);
            throw new RuntimeException(e);
        }
    }
}
