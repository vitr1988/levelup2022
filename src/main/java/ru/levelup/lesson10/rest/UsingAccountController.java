package ru.levelup.lesson10.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.levelup.lesson10.dto.AccountDto;

@RestController
@RequiredArgsConstructor
public class UsingAccountController {

    private final RestTemplate restTemplate;

    @GetMapping("/account-search")
    public Long getAccountId(@RequestParam String name) {
        ResponseEntity<AccountDto> result = restTemplate.getForEntity(String.format("http://localhost:8081/levelup/api/accounts?search=%s", name), AccountDto.class);
        if (result.hasBody()) {
            return result.getBody().getId();
        }
        throw new IllegalArgumentException("Банковский счет с таким владельцем не найден!");
    }

}
