package fr.planandchill.rest.models;
import fr.planandchill.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;

public class ResponseApi<T> implements HttpStatusCode {

    private T result;

    private List<String> errors;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ResponseApi(Customer execute, HttpStatus ok) {
        this.errors = new ArrayList<>();
    }

    public ResponseApi(T result) {
        this.result = result;
        this.errors = new ArrayList<>();
    }

    public ResponseApi(List<String> errors) {
        this.errors = errors;
    }
}