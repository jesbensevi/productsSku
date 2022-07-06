package cl.challenge.challengeskuproduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(){
        super();
    }

    public ProductNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(final String message) {
        super(message);
    }

    public ProductNotFoundException(final Throwable cause) {
        super(cause);
    }

}
