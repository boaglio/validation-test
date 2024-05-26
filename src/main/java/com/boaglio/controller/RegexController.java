package com.boaglio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegexController {

    @GetMapping("/validate-regex")
    public ResponseEntity<String> validateEmail(@RequestParam String email) {

        if (isValid(email)) {
            return ResponseEntity.ok("Valid email: 200 OK");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email: 400 Bad Request");
        }

    }

    static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    boolean isValid(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

}
