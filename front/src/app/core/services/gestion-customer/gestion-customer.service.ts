import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Customer} from "../../../customer/customer";

@Injectable({
  providedIn: 'root'
})
export class GestionCustomerService {

  constructor(private http: HttpClient) {
  }

  createCustomer(customer: Customer): Observable<Customer> {
    const httpOptions = {
      headers: new HttpHeaders({ "Content-Type": "application/json" }),
    };
    return this.http.post<Customer>(`http://localhost:8080/api/customer/save`, customer, httpOptions).pipe(
        tap((response) => this.log(response)),
        catchError((error) => this.handleError(error, null))
    );
  }

  loginCustomer(customer: Customer): Observable<Customer> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Bearer ${customer}`
      }),
    };
    return this.http.post<Customer>(`http://localhost:8080/api/auth/customer/login`, customer, httpOptions).pipe(
        tap((response) => this.log(response)),
        catchError((error) => this.handleError(error, null))
    );
  }

  private log(response: any) {
    console.table(response);
  }

  private handleError(error: Error, errorValue: any) {
    console.log(error);
    return of(errorValue);
  }
}
