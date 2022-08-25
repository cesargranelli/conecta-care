package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.repository.DocumentoUsuarioRepository;
import com.sevenine.conecta.repository.data.DocumentoUsuario;
import com.sevenine.conecta.services.DocumentoUsuarioService;
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
