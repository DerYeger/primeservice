package eu.yeger.primeservice.exception;

public class NumberSizeException extends PrimalityTestException {

    public NumberSizeException(final int value, final int maxValue) {
        super("Max value is " + maxValue + " but received " + value);
    }
}
