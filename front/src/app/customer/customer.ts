export class Customer {
    id: number;
    firstname: string;
    lastname: string;
    phone: string;
    email: string;
    password: string;
    address: string;
    zipCode: string;
    city: string;
    country: string;
    advertising: boolean;

    constructor(
        firstname: string = '',
        lastname: string = '',
        phone: string  = '',
        email: string  = '',
        password: string = '',
        advertising: boolean  = false
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.advertising = advertising;
    }
}