package fr.planandchill.models;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean accountLocked = false;
    private LocalDateTime creationDate;
    private Boolean advertising;

    public Customer() {

    }
}
