package fr.planandchill.authentification;

import fr.planandchill.ports.auth.IAuthentificationPT;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthUtils implements IAuthentificationPT {
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }
}
