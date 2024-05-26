package com.boaglio.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserComValidacao(
    @NotNull
    @Email
    String email

){}