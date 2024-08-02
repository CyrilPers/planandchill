package fr.planandchill.ports.customer;

import fr.planandchill.domain.UserDN;

import java.net.UnknownHostException;
import java.sql.SQLException;

public interface IUserRepositoryPT {

    UserDN load(String email) throws UnknownHostException, SQLException;
}
