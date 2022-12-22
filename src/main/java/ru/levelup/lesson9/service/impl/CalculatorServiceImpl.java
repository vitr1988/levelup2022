package ru.levelup.lesson9.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.lesson9.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Long summa(Long a, Long b) {
        return a + b;
    }
}
