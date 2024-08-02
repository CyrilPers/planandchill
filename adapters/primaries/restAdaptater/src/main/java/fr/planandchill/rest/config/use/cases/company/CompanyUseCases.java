package fr.planandchill.rest.config.use.cases.company;

import fr.planandchill.use.cases.company.CreateCompanyUE;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyUseCases {

    private CreateCompanyUE createCompanyUE;
}
