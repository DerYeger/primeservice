package eu.yeger.primeservice.exception;

import org.springframework.http.HttpStatus;

public class NumberSizeException extends PrimeTestException {

    public NumberSizeException(final int value, final int maxValue) {
        super("Max value is " + maxValue + " but received " + value);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
