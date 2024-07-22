import { Component } from '@angular/core';
import { ReviewsComponent } from './reviews/reviews.component';
import { CompanyServicesComponent } from './company-services/company-services.component';
import { CarouselComponent } from '../reusable/carousel/carousel.component';
import { CollaboraterComponent } from './collaborater/collaborater.component';

@Component({
    selector: 'app-company',
    templateUrl: './company.component.html',
    styleUrls: ['./company.component.scss'],
    standalone: true,
    imports: [CarouselComponent, CompanyServicesComponent, ReviewsComponent, CollaboraterComponent]
})
export class CompanyComponent {

    images = [
        {
          imageSrc:
            'https://images.unsplash.com/photo-1460627390041-532a28402358?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',
          imageAlt: 'nature1',
        },
        {
          imageSrc:
            'https://images.unsplash.com/photo-1470252649378-9c29740c9fa8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',
          imageAlt: 'nature2',
        },
    ];

    constructor() {}

}
