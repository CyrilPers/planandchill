package fr.planandchill.repositories;
import fr.planandchill.models.Customer;
import fr.planandchill.ports.customer.ICustomerRepositoryPT;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.net.UnknownHostException;
import java.sql.SQLException;

@NoArgsConstructor
public abstract class CustomerJpaRepository implements ICustomerRepositoryPT {
    private EntityManager em;

    @Query("SELECT c from Customer c")
    Iterable<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public Customer create(Customer customer) throws UnknownHostException, SQLException {
        em.getTransaction().begin();
        Customer c = em.merge(customer);
        em.getTransaction().commit();
        return c;
    }
}
