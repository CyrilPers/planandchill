import { Routes } from "@angular/router";
import { map } from "rxjs/operators";
import { HomeComponent } from "./home/home.component";
import { CompanyComponent } from "./company/company.component";
import { SignInComponent } from "./sign-in/sign-in.component";
import { SignUpComponent } from "./sign-up/sign-up.component";
export const routes: Routes = [
  {
    path: "",
    loadComponent: () => HomeComponent,
  },
  {
    path: "company",
    loadComponent: () => CompanyComponent,
  },
  {
    path: "sign-in",
    loadComponent: () => SignInComponent,
  },
  {
    path: "sign-up",
    loadComponent: () => SignUpComponent,
  },
  {
    path: "**",
    loadComponent: () => HomeComponent,
  },
];