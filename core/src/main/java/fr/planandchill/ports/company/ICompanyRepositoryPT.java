package fr.planandchill.ports.company;
import fr.planandchill.domain.WorkerDN;

public interface ICompanyRepositoryPT {
    WorkerDN create(WorkerDN workerDN);
}
