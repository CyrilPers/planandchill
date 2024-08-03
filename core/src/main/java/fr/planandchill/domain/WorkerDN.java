package fr.planandchill.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WorkerDN {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean accountLocked;
    private LocalDateTime creationDate;
    private List<RoleDN> roles;
    private List<CompanyDN> companies;
}
