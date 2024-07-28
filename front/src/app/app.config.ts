import {ApplicationConfig} from "@angular/core";
import {provideRouter, RouterModule} from "@angular/router";

import {routes} from "./app.routes";
import {EMPTY} from "rxjs";
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {provideHttpClient} from "@angular/common/http";


export const appConfig: ApplicationConfig = {
    providers: [
        provideHttpClient(),
        provideRouter(routes),
        provideAnimationsAsync(),
    ]
};