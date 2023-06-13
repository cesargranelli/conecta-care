package com.sevenine.usuario.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaUsuario {
    private String username;
    private List<String> roles;
    private String module;
}
