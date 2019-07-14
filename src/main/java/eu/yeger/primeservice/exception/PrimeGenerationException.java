package eu.yeger.primeservice.exception;

import org.springframework.http.HttpStatus;

public class PrimeGenerationException extends HttpStatusException {

    public PrimeGenerationException() {
        super("Prime generation in progress");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
