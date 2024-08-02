package fr.planandchill.repositories;

import fr.planandchill.domain.UserDN;
import fr.planandchill.entities.User;
import fr.planandchill.ports.customer.IUserRepositoryPT;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.sql.SQLException;


public class UserJpaRepository implements IUserRepositoryPT {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDN findByEmail(String email) throws SQLException {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            User user = query.getSingleResult();
            UserDN userDN = UserDN
                    .builder()
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .password(user.getPassword())
                    .build();
            return userDN;
        } catch (NoResultException e) {
            throw new UsernameNotFoundException("User not found " + email);
        } catch (Exception e) {
            LOG.error("Error while loading customer ", e);
            throw new SQLException("Error while loading customer ", e);
        }

    }



}
