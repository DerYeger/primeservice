package eu.yeger.primeservice.util;

import eu.yeger.primeservice.repository.PrimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeGenerator implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final int[] smallestPrimeDivisor;
    private final PrimeRepository primeRepository;
    private final int maxValue;

    public PrimeGenerator(final PrimeRepository primeRepository, final int maxValue) {
        this.primeRepository = primeRepository;
        this.maxValue = maxValue;
        smallestPrimeDivisor = new int[maxValue + 1];
        Arrays.fill(smallestPrimeDivisor, 2);
    }

    @Override
    public void run() {
        final double startTime = System.currentTimeMillis();

        final ArrayList<Integer> knownPrimes = new ArrayList<>();
        knownPrimes.add(2);

        for (int number = 3; number <= maxValue; number += 2) {
            boolean isPrime = true;

            for (final int prime : knownPrimes) {
                if (number % prime == 0) {
                    isPrime = false;
                    markNonPrime(number, prime);
                    break;
                } else if (prime * prime > number) {
                    break;
                }
            }

            if (isPrime) {
                knownPrimes.add(number);
                markPrime(number);
            }
        }

        final double endTime = System.currentTimeMillis();
        logger.debug("Completed prime generation in " + ((endTime - startTime) / 1000) + " seconds");
        primeRepository.setData(smallestPrimeDivisor);
    }

    private void markPrime(final int prime) {
        smallestPrimeDivisor[prime] = prime;
    }

    private void markNonPrime(final int number, final int smallestPrimeFactor) {
        smallestPrimeDivisor[number] = smallestPrimeFactor;
    }
}
