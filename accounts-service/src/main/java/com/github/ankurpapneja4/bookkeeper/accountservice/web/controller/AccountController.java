package com.github.ankurpapneja4.bookkeeper.accountservice.web.controller;

import com.github.ankurpapneja4.bookkeeper.accountservice.services.AccountService;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.AccountDtoPagedList;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/v1/accounts/{accountId}")
    public ResponseEntity<AccountDto> getAccountById( @PathVariable("accountId") Long accountId ) {
        return ResponseEntity.ok( accountService.findById(accountId) );
    }


    @GetMapping("/api/v1/accounts")
    public ResponseEntity<AccountDtoPagedList> getAccounts(
                @RequestParam(value = "pageNum",  defaultValue = "0",  required = false) Integer pageNum,
                @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        Assert.isTrue( pageNum  >= 0, "Invalid pageNum" );
        Assert.isTrue( pageSize >= 0, "Invalid pageSize");

        return ResponseEntity.ok(
                    accountService.findAll( PageRequest.of( pageNum, pageSize) ));
    }

    @PostMapping("/api/v1/accounts")
    public ResponseEntity createAccount(@Valid @RequestBody AccountDto accountDto, HttpServletRequest request) {

        Long accountId = accountService.createAccount( accountDto );
        String location = request.getRequestURL().append("/").append(accountId).toString();

        return ResponseEntity.created( URI.create( location) ).build();
    }





}
