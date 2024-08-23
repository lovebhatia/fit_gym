package com.gym.fit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
     @GetMapping("/api/health")
    public ResponseEntity<String> healthCheck() {
        System.out.println("in Health Check");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    
}
