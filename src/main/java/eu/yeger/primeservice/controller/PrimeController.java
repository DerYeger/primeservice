package eu.yeger.primeservice.controller;

import eu.yeger.primeservice.exception.PrimeTestException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.service.PrimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prime")
public class PrimeController {

    private final PrimeService primeService;

    public PrimeController(final PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/test")
    public ResponseEntity test(@RequestParam final int number) {
        try {
            return ResponseEntity
                    .ok(primeService.isPrime(number));
        } catch (final PrimeTestException | PrimeGenerationException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e.getMessage());
        }
    }
}
