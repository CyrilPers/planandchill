package fr.planandchill.repositories;

import fr.planandchill.entities.User;
import fr.planandchill.models.Customer;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerJpaRepository implements ICustomerRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Customer create(Customer customer) throws SQLException {

        fr.planandchill.entities.Customer customerEntity = new fr.planandchill.entities.Customer();
        customerEntity.setId(customer.getId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setCreationDate(customer.getCreationDate());
        try {
            em.persist(customerEntity);
            return customer;
        } catch (Exception e) {
            LOG.error("Error while persisting customer ", e);
           throw new SQLException("Error while persisting customer ");
        }
    }

    @Override
    public List<Customer> getAll() throws UnknownHostException, SQLException {
        return new ArrayList<>();
    }

    @Override
    public Customer findById(String id) throws UnknownHostException, SQLException {
        return null;
    }
}
