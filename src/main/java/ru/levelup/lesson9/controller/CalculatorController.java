package ru.levelup.lesson9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson9.service.CalculatorService;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/summa")
    public Long summa(@RequestParam(required = false, defaultValue = "5") Long a,
                      @RequestParam(required = false, defaultValue = "25") Long b) {
        return calculatorService.summa(a, b);
    }

    @PostMapping("/summa")
    public Long minus(@RequestParam(required = false, defaultValue = "5") Long a,
                      @RequestParam(required = false, defaultValue = "25") Long b) {
        return a - b;
    }
}
