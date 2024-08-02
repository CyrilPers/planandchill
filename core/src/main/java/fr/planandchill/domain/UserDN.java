package fr.planandchill.domain;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private List<RoleDN> roles;
}
