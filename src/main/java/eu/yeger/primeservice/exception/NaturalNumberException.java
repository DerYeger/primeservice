package eu.yeger.primeservice.exception;

import org.springframework.http.HttpStatus;

public class NaturalNumberException extends PrimeTestException {

    public NaturalNumberException(final int value) {
        super(value + " is not a natural number");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
