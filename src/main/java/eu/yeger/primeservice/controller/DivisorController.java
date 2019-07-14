package eu.yeger.primeservice.controller;

import eu.yeger.primeservice.exception.FactorException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.service.DivisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/divisor")
public class DivisorController {

    private final DivisorService divisorService;

    public DivisorController(final DivisorService divisorService) {
        this.divisorService = divisorService;
    }

    @GetMapping("/get")
    public ResponseEntity getDivisor(@RequestParam final int number) {
        try {
            return ResponseEntity
                    .ok(divisorService.getDivisors(number));
        } catch (final FactorException | PrimeGenerationException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e.getMessage());
        }
    }
}
