package eu.yeger.primeservice.controller;

import eu.yeger.primeservice.exception.FactorException;
import eu.yeger.primeservice.exception.PrimeGenerationException;
import eu.yeger.primeservice.service.FactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factors")
public class FactorController {

    private final FactorService factorService;

    public FactorController(final FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping("/get")
    public ResponseEntity getFactor(@RequestParam final int number) {
        try {
            return ResponseEntity
                    .ok(factorService.getFactors(number));
        } catch (final FactorException | PrimeGenerationException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e.getMessage());
        }
    }
}
