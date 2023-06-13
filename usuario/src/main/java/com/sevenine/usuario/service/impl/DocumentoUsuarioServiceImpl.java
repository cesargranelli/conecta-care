package com.sevenine.usuario.services.impl;

import com.sevenine.usuario.repository.DocumentoUsuarioRepository;
import com.sevenine.usuario.repository.data.DocumentoUsuario;
import com.sevenine.usuario.services.DocumentoUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DocumentoUsuarioServiceImpl implements DocumentoUsuarioService {

    private final DocumentoUsuarioRepository repository;

    @Override
    public void associar(Long idSequenceCadastro, Long idUsuario) {
        repository.save(DocumentoUsuario.builder().idSequenceCadastro(idSequenceCadastro).idUsuario(idUsuario).build());
    }

}
