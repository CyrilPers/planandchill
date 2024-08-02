package fr.planandchill.repositories;

import fr.planandchill.domain.UserDN;
import fr.planandchill.entities.Customer;
import fr.planandchill.ports.customer.IUserRepositoryPT;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class UserJpaRepository implements IUserRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDN load(String email) throws SQLException {
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", Customer.class);
            UserDN result = (UserDN) query.getResultList();
            return result;
        } catch (Exception e) {
            LOG.error("Error while loading customer ", e);
            throw new SQLException("Error while loading customer ");
        }
    }



}
