package com.sevenine.conecta.http.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CadastroUsuarioRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private String role;

    @NotNull
    private Long sequence;

}
