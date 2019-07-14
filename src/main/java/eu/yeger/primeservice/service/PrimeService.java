package eu.yeger.primeservice.service;

import eu.yeger.primeservice.exception.PrimeTestException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.repository.PrimeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {

    private final PrimeRepository primeRepository;

    public PrimeService(final PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public boolean isPrime(final int number) throws PrimeTestException, PrimeGenerationException {
        return primeRepository.contains(number);
    }
}
