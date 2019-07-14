package eu.yeger.primeservice.exception;

public class NaturalNumberException extends PrimalityTestException {

    public NaturalNumberException(final int value) {
        super(value + " is not a natural number");
    }
}
