package fr.planandchill.domain;

import java.time.LocalDateTime;

public class UserDN {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean accountLocked = false;
    private String creationDate;
}
