import {Routes} from "@angular/router";

export const routes: Routes = [
    {
        path: "",
        loadComponent: () => import('./home/home.component').then(mod => mod.HomeComponent)
    },
    {
        path: "company",
        children: [
            {
                path: 'sign-up',
                loadComponent: () => import('./company/sign-up/company-sign-up.component').then(mod => mod.CompanySignUpComponent)
            },
            {
                path: '',
                loadComponent: () => import('./company/company.component').then(mod => mod.CompanyComponent)
            }
        ],
    },
    {
        path: "sign-in",
        loadComponent: () => import('./sign-in/sign-in.component').then(mod => mod.SignInComponent),
    },
    {
        path: "sign-up",
        loadComponent: () => import('./sign-up/sign-up.component').then(mod => mod.SignUpComponent)
    },
    {
        path: "**",
      loadComponent: () => import('./page-not-found/page-not-found.component').then(mod => mod.PageNotFoundComponent)
    },
];