package eu.yeger.primeservice.repository;

import eu.yeger.primeservice.exception.NaturalNumberException;
import eu.yeger.primeservice.exception.NumberSizeException;
import eu.yeger.primeservice.exception.PrimalityTestException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.util.PrimeGenerator;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrimeRepository {

    private int[] smallestPrimeDivisor;
    private final int maxValue;

    private final AtomicBoolean ready = new AtomicBoolean(false);

    public PrimeRepository(final int maxValue) {
        this.maxValue = maxValue;

        new Thread(new PrimeGenerator(this, maxValue))
                .start();
    }

    public boolean contains(final int number) throws PrimalityTestException {
        if (!ready.get()) throw new PrimeGenerationException();
        if (number > maxValue) throw new NumberSizeException(number, maxValue);
        if (number < 0) throw new NaturalNumberException(number);
        if (number < 2 || number % 2 == 0) return false;

        return smallestPrimeDivisor[number] == number;
    }

    public void setData(final int[] smallestPrimeDivisor) {
        this.smallestPrimeDivisor = smallestPrimeDivisor;
        ready.set(true);
    }
}
