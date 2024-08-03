package fr.planandchill.ports.worker;
import fr.planandchill.domain.WorkerDN;

import java.net.UnknownHostException;
import java.sql.SQLException;

public interface IWorkerRepositoryPT {

    WorkerDN create(WorkerDN workerDN) throws UnknownHostException, SQLException;
}
