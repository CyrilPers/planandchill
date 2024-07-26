package fr.planandchill.rest.models;
import fr.planandchill.models.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ResponseApi<T> {

    private T result;

    private List<String> errors;

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