package eu.yeger.primeservice.exception;

public abstract class PrimeTestException extends HttpStatusException {

    public PrimeTestException(final String message) {
        super(message);
    }
}
