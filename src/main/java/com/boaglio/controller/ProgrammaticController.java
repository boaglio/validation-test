package com.boaglio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgrammaticController {

    @GetMapping("/validate-programmatic")
    public ResponseEntity<String> validateEmail(@RequestParam String email) {

        if (isValid(email)) {
            return ResponseEntity.ok("Valid email: 200 OK");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email: 400 Bad Request");
        }

    }

    boolean isValid(String email) {
        if (email == null) return false;
        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");

        return atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1;
    }

}
