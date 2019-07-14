package eu.yeger.primetest.config;

import eu.yeger.primetest.repository.PrimeRepository;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public PrimeRepository primeRepository() {
        return new PrimeRepository(40000000);
    }
}
