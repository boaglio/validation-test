package com.boaglio.controller;

import com.boaglio.dto.UserComValidacao;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Validated
public class HibernateValidatorController {

    @Autowired
    private Validator validator;

    @GetMapping("/validate-hibernate")
    public ResponseEntity<String> validateEmail(@RequestParam String email) {
        UserComValidacao user = new UserComValidacao(email);
        
        Set<ConstraintViolation<UserComValidacao>> violations = validator.validate(user);
        if (violations.isEmpty()) {
            return ResponseEntity.ok("Valid email: 200 OK");
        } else {
            StringBuilder violationMessages = new StringBuilder();
            for (ConstraintViolation<UserComValidacao> violation : violations) {
                violationMessages.append(violation.getMessage()).append("\n");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email: 400 Bad Request\n" + violationMessages.toString());
        }
    }
}
