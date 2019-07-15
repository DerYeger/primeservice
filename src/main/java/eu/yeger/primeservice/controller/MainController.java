package eu.yeger.primeservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController implements ErrorController {

    @GetMapping("")
    public String showIndex() {
        return "homePage";
    }

    @GetMapping("prime")
    public String showPrime() {
        return "primePage";
    }

    @GetMapping("factors")
    public String showFactor() {
        return "factorsPage";
    }

    @GetMapping("divisors")
    public String showDivisor() {
        return "divisorsPage";
    }

    @GetMapping("imprint")
    public String showImprint() {
        return "imprintPage";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
