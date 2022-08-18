package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.exception.CadastroIncompletoException;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.repository.data.Usuario;
import com.sevenine.conecta.service.ConsultaUsuarioService;
import com.sevenine.conecta.service.ValidaCadastroAtivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ValidaCadastroAtivoServiceImpl implements ValidaCadastroAtivoService {

    private final ConsultaUsuarioService consultaUsuarioService;

    @Override
    public void validar(String email, String modulo) {
        Usuario usuario = consultaUsuarioService.buscarUsuario(email);
        List<SequenceCadastro> documentosUsuario = usuario.getDocumentoUsuario();
        Optional<SequenceCadastro> optional = documentosUsuario.stream()
                .filter(documentoUsuario -> documentoUsuario.getModulo().name().equals(modulo))
                .findFirst();

        if (!optional.isPresent() || optional.get().getStatus().equals(StatusCadastro.PENDENTE)) {
            throw new CadastroIncompletoException("Pendente de confirmação ou cadastro incompleto!", HttpStatus.PRECONDITION_FAILED);
        }
    }

}
