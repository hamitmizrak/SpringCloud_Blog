package com.hamitmizrak.accountservice.ui.api;

import com.hamitmizrak.accountservice.business.dto.AccountDto;
import com.hamitmizrak.accountservice.business.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok
@RequiredArgsConstructor

//REST
@RestController
@RequestMapping("account")
public class AccountApi {

    //Injection
    private final AccountService accountService;

    //http:localhost:8080/account
    //CREATE
    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    //http:localhost:8080/account
    //LIST
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllList() {
        return ResponseEntity.ok(accountService.getAllList());
    }

    //http:localhost:8080/account/1
    //FIND
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getFindId(@PathVariable("id")  String id) {
        return ResponseEntity.ok(accountService.getFindId(id));
    }

    //http:localhost:8080/account/1
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable("id")  String id, @RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.update(id,account));
    }

    //http:localhost:8080/account/1
    //DELETE
    //delete id yeterli obje göndermiyorum ki serveri yormamayayımö
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")  String id) {
        accountService.delete(id);
    }
}
