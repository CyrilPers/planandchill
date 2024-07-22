import { Component, ViewChild } from '@angular/core';
import { ButtonComponent } from '../reusable/button/button.component';
import { FormsModule, NgForm} from '@angular/forms';
import { checkForm } from '../utils/checkPassword';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [ButtonComponent, FormsModule, RouterLink],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css',
})
export class SignInComponent {
  passwordErrors: String [] = [];
  @ViewChild('signInForm') signInForm: NgForm;

  ngOnInit(): void {
  }
  
  onSubmit = ():void => {
    this.checkPassword()
  }

  checkPassword = () => {
      this.passwordErrors = checkForm(this.signInForm.value.password)
  }

}
