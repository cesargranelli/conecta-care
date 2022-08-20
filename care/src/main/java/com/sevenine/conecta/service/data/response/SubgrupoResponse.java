package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubgrupoResponse {
    private Long id;
    private String descricao;
    private List<CampoResponse> campos;
}
