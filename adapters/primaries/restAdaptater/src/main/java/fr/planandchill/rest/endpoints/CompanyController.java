package fr.planandchill.rest.endpoints;
import fr.planandchill.domain.CompanyDN;
import fr.planandchill.domain.WorkerDN;
import fr.planandchill.entities.Worker;
import fr.planandchill.use.cases.worker.CreateWorkerUE;
import fr.planandchill.use.cases.company.CreateCompanyUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final Logger LOG = LoggerFactory.getLogger(CompanyController.class);

    private final CreateWorkerUE createWorkerUE;

    private final CreateCompanyUE createCompanyUE;

    @Autowired
    public CompanyController(CreateWorkerUE createWorkerUE, CreateCompanyUE createCompanyUE) {
        this.createWorkerUE = createWorkerUE;
        this.createCompanyUE = createCompanyUE;
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST}, allowedHeaders = {"Content-Type", "Authorization"})
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody WorkerDN workerDN) {
        try {
            WorkerDN worker = this.createCompanyUE.execute(workerDN);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Erreur technique : Veuillez contacter le support technique", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
