package com.sevenine.conecta.http.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CadastroResponse {
    private String token;
}
