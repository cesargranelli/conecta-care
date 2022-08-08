package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {
    ROLE_ADMIN_ROOT, ROLE_PROFISSIONAL, ROLE_PACIENTE, ROLE_HOMECARE, ROLE_PLANO_SAUDE, ROLE_PLANO_SAUDE_FILIAL;
}
