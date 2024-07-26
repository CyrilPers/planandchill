package fr.planandchill.repositories;

import fr.planandchill.models.Customer;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CustomerJpaRepository implements ICustomerRepositoryPT {
    private EntityManager em;

    @Override
    public Customer create(Customer customer) throws UnknownHostException, SQLException {
        try {
            em.getTransaction().begin();
            Customer c = em.merge(customer);
            em.getTransaction().commit();
            return c;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
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
