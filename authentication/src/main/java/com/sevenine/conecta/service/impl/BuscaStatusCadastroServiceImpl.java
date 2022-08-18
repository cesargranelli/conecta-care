package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.repository.data.Usuario;
import com.sevenine.conecta.service.BuscaStatusCadastroService;
import com.sevenine.conecta.service.ConsultaUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuscaStatusCadastroServiceImpl implements BuscaStatusCadastroService {

    private final ConsultaUsuarioService consultaUsuarioService;

    @Override
    public StatusCadastro validar(String email, String modulo) {
        Usuario usuario = consultaUsuarioService.buscarUsuario(email);
        return usuario.getDocumentoUsuario().stream()
                .filter(documentoUsuario -> documentoUsuario.getModulo().name().equals(modulo))
                .findFirst().orElse(SequenceCadastro.builder()
                        .status(StatusCadastro.INCOMPLETO)
                        .build()).getStatus();
    }

}
