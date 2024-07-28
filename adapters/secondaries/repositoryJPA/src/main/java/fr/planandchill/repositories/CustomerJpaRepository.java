package fr.planandchill.repositories;

import fr.planandchill.entities.Customer;
import fr.planandchill.entities.PostalCode;
import fr.planandchill.models.CustomerDN;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerJpaRepository implements ICustomerRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public CustomerDN create(CustomerDN customerDN) throws SQLException {
        Customer customer = new Customer();
        customer.setId(customerDN.getId());
        customer.setFirstName(customerDN.getFirstName());
        customer.setLastName(customerDN.getLastName());
        customer.setEmail(customerDN.getEmail());
        customer.setPassword(customerDN.getPassword());
        customer.setPhoneNumber(customerDN.getPhoneNumber());
        customer.setCreationDate(customerDN.getCreationDate());
        customer.setAdvertising(false);


        try {
            em.persist(customer);
            return customerDN;
        } catch (Exception e) {
            LOG.error("Error while persisting customerDN ", e);
            throw new SQLException("Error while persisting customerDN ");
        }
    }

    @Override
    public List<CustomerDN> getAll() throws UnknownHostException, SQLException {
        return new ArrayList<>();
    }

    @Override
    public CustomerDN findById(String id) throws UnknownHostException, SQLException {
        return null;
    }
}
