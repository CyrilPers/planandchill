package fr.planandchill.rest.endpoints;

import fr.planandchill.models.Customer;
import fr.planandchill.use.cases.customer.CreateCustomerUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CreateCustomerUE createCustomerUE;

    @Autowired
    public CustomerController(CreateCustomerUE createCustomerUE) {
        this.createCustomerUE = createCustomerUE;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(this.createCustomerUE.execute(customer), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur technique : Veuillez contacter le support technique", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
