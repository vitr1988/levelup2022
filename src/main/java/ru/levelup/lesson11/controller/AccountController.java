package ru.levelup.lesson11.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson11.dto.AccountDto;

//@RestController
@Controller
@RequestMapping("/api/accounts")
public class AccountController {

    @ResponseBody
    @PostMapping//(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        System.out.println(accountDto);
//        return ResponseEntity.ok(accountDto);
        return ResponseEntity.ok().build();
    }

}
