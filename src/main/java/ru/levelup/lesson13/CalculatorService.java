package ru.levelup.lesson13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final PrintService printService;

    public int summa(int a, int b) {
        int result = a + b;
        printService.print(result);
        return result;
    }

    public int minus(int a, int b) {
        int result = a - b;
        printService.print(result);
        return result;
    }

    public int divide(int a, int b) {
        int result = a / b;
        printService.print(result);
        return result;
    }
}
