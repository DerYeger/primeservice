package eu.yeger.primeservice.exception;

import org.springframework.http.HttpStatus;

public abstract class HttpStatusException extends Exception {

    public HttpStatusException(final String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();
}
