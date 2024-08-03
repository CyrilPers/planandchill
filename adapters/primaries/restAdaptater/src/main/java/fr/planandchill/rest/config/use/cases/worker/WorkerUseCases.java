package fr.planandchill.rest.config.use.cases.worker;

import fr.planandchill.use.cases.worker.CreateWorkerUE;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerUseCases {
    private CreateWorkerUE createWorkerUE;
}
