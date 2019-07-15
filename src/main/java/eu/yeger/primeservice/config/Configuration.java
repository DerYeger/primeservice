package eu.yeger.primeservice.config;

import eu.yeger.primeservice.repository.PrimeRepository;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    public static final int MAX_VALUE = 40000000;

    @Bean
    public PrimeRepository primeRepository() {
        return new PrimeRepository(MAX_VALUE);
    }
}
