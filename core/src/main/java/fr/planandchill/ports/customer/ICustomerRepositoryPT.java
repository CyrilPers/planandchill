package fr.planandchill.ports.customer;

import fr.planandchill.models.Customer;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepositoryPT {

    Customer create(Customer customer) throws UnknownHostException, SQLException;

    List<Customer> getAll() throws UnknownHostException, SQLException;

    Customer findById(String id) throws UnknownHostException, SQLException;
}
