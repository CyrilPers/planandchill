import { ApplicationConfig } from "@angular/core";
import { provideRouter } from "@angular/router";

import { routes } from "./app.routes";
import { EMPTY } from "rxjs";


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
  ]
};