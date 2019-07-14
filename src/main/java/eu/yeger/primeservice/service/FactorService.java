package eu.yeger.primeservice.service;

import eu.yeger.primeservice.exception.FactorException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.repository.PrimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FactorService {

    private final PrimeRepository primeRepository;

    public FactorService(final PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public Collection<Integer> getFactors(final int number) throws FactorException, PrimeGenerationException {
        if (number < 0) throw new FactorException();
        if (number < 4) return List.of(number);

        final ArrayList<Integer> factors = new ArrayList<>();

        int remainder = number;

        while (remainder != 1) {
            final int factor = primeRepository.smallestFactorOf(remainder);
            factors.add(factor);
            remainder /= factor;
        }

        return factors;
    }
}
