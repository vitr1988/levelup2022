package ru.levelup.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrintService {

    public void print(int result) {
        log.info("Result {}", result);
    }

    public int printAndGet(int result) {
        log.info("Result {}", result);
        return 0;
    }
}
