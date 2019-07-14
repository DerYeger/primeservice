package eu.yeger.primeservice.exception;

public class PrimeGenerationException extends PrimalityTestException {

    public PrimeGenerationException() {
        super("Prime generation is not finished");
    }
}
