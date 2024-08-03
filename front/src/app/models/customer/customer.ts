export class Customer {
    id: number;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    password: string;
    advertising: boolean;

    constructor(
        firstName: string = '',
        lastName: string = '',
        phone: string  = '',
        email: string  = '',
        password: string = '',
        advertising: boolean  = false
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.advertising = advertising;
    }
}