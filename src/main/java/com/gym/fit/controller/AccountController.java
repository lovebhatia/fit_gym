package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    
    
    @GetMapping("/delete")
    public ResponseEntity<String> deleteAccount() {
        Long userId = (long) 8;
        boolean isDeleted = accountService.deleteAccount(userId);
        //if (isDeleted) {
          //  return ResponseEntity.ok("Account deleted successfully.");
        //} else {
          //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        //}
        return ResponseEntity.ok("Account deleted successfully.");
    }

}