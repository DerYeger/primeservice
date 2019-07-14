package eu.yeger.primeservice.exception;

import org.springframework.http.HttpStatus;

public class FactorException extends HttpStatusException {

    public FactorException() {
        super("Unsupported number");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
