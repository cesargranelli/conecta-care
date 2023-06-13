package com.sevenine.usuario.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Role implements GrantedAuthority {
    private final String tipo;

    @Override
    public String getAuthority() {
        return tipo;
    }
}
