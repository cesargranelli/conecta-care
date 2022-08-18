package com.sevenine.conecta.http.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@RequiredArgsConstructor
public class LoginUsuarioRequest {
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private String modulo;
}
