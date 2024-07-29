package fr.planandchill.ports.customer;

import fr.planandchill.domain.CustomerDN;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepositoryPT {

    CustomerDN create(CustomerDN customerDN) throws UnknownHostException, SQLException;

    CustomerDN load(String email) throws UnknownHostException, SQLException;

    List<CustomerDN> getAll() throws UnknownHostException, SQLException;

    CustomerDN findById(String id) throws UnknownHostException, SQLException;
}
