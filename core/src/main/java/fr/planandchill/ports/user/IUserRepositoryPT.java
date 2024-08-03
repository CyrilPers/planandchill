package fr.planandchill.ports.user;

import fr.planandchill.domain.UserDN;

import java.net.UnknownHostException;
import java.sql.SQLException;

public interface IUserRepositoryPT {

    UserDN findByEmail(String email) throws UnknownHostException, SQLException;
}
