import { Component, ViewChild } from '@angular/core';
import { ButtonComponent } from '../reusable/button/button.component';
import { FormsModule, NgForm} from '@angular/forms';
import { checkForm } from '../utils/checkPassword';
import {Customer} from "../customer/customer";
import {GestionCustomerService} from "../core/services/gestion-customer/gestion-customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [ButtonComponent, FormsModule],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css',
})
export class SignInComponent {

  passwordErrors: String [] = [];
  customer: Customer;
  @ViewChild('signInForm') signInForm: NgForm;

  constructor(private router : Router,
              private gestionCustomerSvc: GestionCustomerService) {
    this.router = router;
    this.gestionCustomerSvc = gestionCustomerSvc;
  }

  ngOnInit(): void {
    this.customer = new Customer();
  }
  
  onSubmit = ():void => {
    console.log("init", this.customer);
    this.gestionCustomerSvc.loginCustomer(this.customer).subscribe(() =>
        this.router.navigate(["/profil"])
    );
  }
}
