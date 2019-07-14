package eu.yeger.primetest.util;

import eu.yeger.primetest.repository.PrimeRepository;

import java.util.ArrayList;

public class PrimeGenerator implements Runnable {

    private final int[] smallestPrimeDivisor;
    private final PrimeRepository primeRepository;
    final int maxValue;

    public PrimeGenerator(final PrimeRepository primeRepository, final int maxValue) {
        this.primeRepository = primeRepository;
        this.maxValue = maxValue;
        smallestPrimeDivisor = new int[maxValue];
    }

    @Override
    public void run() {
        final ArrayList<Integer> knownPrimes = new ArrayList<>();
        knownPrimes.add(2);

        for (int number = 3; number < maxValue; number += 2) {
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
        System.out.println("Prime generation finished");
        primeRepository.setData(smallestPrimeDivisor);
    }

    private void markPrime(final int prime) {
        smallestPrimeDivisor[prime] = prime;
    }

    private void markNonPrime(final int number, final int smallestPrimeFactor) {
        smallestPrimeDivisor[number] = smallestPrimeFactor;
    }
}
