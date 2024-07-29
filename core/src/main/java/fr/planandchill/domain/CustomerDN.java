package fr.planandchill.domain;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerDN {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean accountLocked;
    private LocalDateTime creationDate;
    private Boolean advertising;


}
