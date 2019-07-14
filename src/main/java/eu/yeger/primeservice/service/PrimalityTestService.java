package eu.yeger.primeservice.service;

import eu.yeger.primeservice.exception.PrimalityTestException;
import eu.yeger.primeservice.repository.PrimeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrimalityTestService {

    private final PrimeRepository primeRepository;

    public PrimalityTestService(final PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public boolean isPrime(final int number) throws PrimalityTestException {
        return primeRepository.contains(number);
    }
}
