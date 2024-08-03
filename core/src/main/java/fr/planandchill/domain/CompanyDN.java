package fr.planandchill.domain;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CompanyDN {
    private Integer id;
    private String name;
    private Integer siret;
    private String description;
    private Boolean enabled;
    private Integer textMessageBalance;
    private String adminLink;
    private LocalDateTime creationDate;
}
