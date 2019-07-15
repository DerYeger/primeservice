package eu.yeger.primeservice.service;

import eu.yeger.primeservice.exception.FactorException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DivisorService {

    private final FactorService factorService;

    public DivisorService(final FactorService factorService) {
        this.factorService = factorService;
    }

    public Collection<Integer> getDivisors(final int number) throws FactorException, PrimeGenerationException {
        final Collection<Integer> factors = factorService.getFactors(number);

        final ArrayList<Integer> distinctFactors = getDistinctFactors(factors);
        final ArrayList<Integer> exponents = getExponents(factors);

        final int divisorCount = divisorCount(exponents);
        final Integer[] divisors = new Integer[divisorCount];
        Arrays.fill(divisors, 1);

        int lastRepeat = divisorCount;

        for (int i = 0; i < distinctFactors.size(); i++) {
            final int prime = distinctFactors.get(i);
            final int exponent = exponents.get(i) + 1;

            final int chunkSize = lastRepeat;
            final int chunk_count = divisorCount / chunkSize;
            final int repeat = chunkSize / exponent;

            final int[] powers = new int[exponent];
            powers[0] = 1;

            for (int j = 1; j < exponent; j++)
            {
                powers[j] = prime * powers[j - 1];
            }

            int index = 0;

            for (int j = 0; j < chunk_count; j++) {
                for (int k = 0; k < exponent; k++) {
                    for (int l = 0; l < repeat; l++) {
                        divisors[index++] *= powers[k];
                    }
                }
            }

            lastRepeat = repeat;
        }

        return Stream
                .of(divisors)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Integer> getDistinctFactors(final Collection<Integer> factors) {
        return factors
                .stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Integer> getExponents(final Collection<Integer> factors) {
        return factors
                .stream()
                .distinct()
                .map(integer -> Collections.frequency(factors, integer))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int divisorCount(final Collection<Integer> exponents) {
        return exponents
                .stream()
                .map(exponent -> exponent + 1)
                .reduce(1, Math::multiplyExact);
    }
}
