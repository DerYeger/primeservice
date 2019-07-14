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

    @GetMapping("factor")
    public String showFactor() {
        return "factorPage";
    }

    @GetMapping("divisor")
    public String showDivisor() {
        return "divisorPage";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
