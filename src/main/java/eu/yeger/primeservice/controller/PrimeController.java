package eu.yeger.primeservice.controller;

import eu.yeger.primeservice.exception.PrimalityTestException;
import eu.yeger.primeservice.service.PrimalityTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prime")
public class PrimeController {

    private final PrimalityTestService primalityTestService;

    public PrimeController(@NonNull final PrimalityTestService primalityTestService) {
        this.primalityTestService = primalityTestService;
    }

    @GetMapping("/test")
    public ResponseEntity test(@NonNull @RequestParam final int number) {
        try {
            return ResponseEntity
                    .ok(primalityTestService.isPrime(number));
        } catch (final PrimalityTestException e) {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(e.getMessage());
        }
    }
}
