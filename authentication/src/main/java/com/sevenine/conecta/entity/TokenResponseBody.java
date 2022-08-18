package com.sevenine.conecta.entity;

import com.sevenine.conecta.enumerator.StatusCadastro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseBody {

    private final String type = "Bearer";
    private final String token;
    private final Long expire;
    private final String refresh;
    private final StatusCadastro status;

    public TokenResponseBody(String accessToken, Long expirationTime, String refreshToken, StatusCadastro statusCadastro) {
        token = accessToken;
        expire = expirationTime / 86400000;
        refresh = refreshToken;
        status = statusCadastro;
    }
}
