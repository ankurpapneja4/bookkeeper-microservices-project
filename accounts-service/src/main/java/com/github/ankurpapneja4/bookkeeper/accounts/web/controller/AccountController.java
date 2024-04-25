package com.github.ankurpapneja4.bookkeeper.accounts.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AccountController {

    @Value("${applicationName}")
    private String applicationName;

    @GetMapping("/api/v1/accounts")
    public ResponseEntity<List<?>> getAccounts(){

        return ResponseEntity.ok(Collections.EMPTY_LIST );

    }

    @GetMapping("/api/v1/app")
    public ResponseEntity<String> getApplicationName(){
        return ResponseEntity.ok( applicationName );
    }


}
