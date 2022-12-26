package ru.levelup.lesson10.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson10.dto.AccountDto;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Random;

@Validated
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@Valid @RequestBody AccountDto accountDto) {
        if (accountDto.getId() != null) {
            throw new IllegalArgumentException("ID should be defined for creating");
        }
        System.out.println(accountDto);
        accountDto.setId(Math.abs(new Random().nextLong()));
        return accountDto;
    }

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable Long id) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(id).setAccountNumber("324124425")
                .setBalance(BigDecimal.ZERO).setOwner("Owner");
        return accountDto;
    }

    @GetMapping
    public AccountDto getAccount(@RequestParam String search) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(new Random().nextLong()).setAccountNumber("45436356")
                .setBalance(BigDecimal.ONE).setOwner("Owner2");
        return accountDto;
    }

    @PutMapping("/{id}")
    public AccountDto updateAccount(@Valid @RequestBody AccountDto accountDto, @PathVariable Long id) {
        accountDto.setId(id);
        return accountDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long id) {

    }
}
