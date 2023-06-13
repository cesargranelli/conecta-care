//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.enumerator.StatusCadastro;
//import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;
//import com.sevenine.usuario.adapter.controller.data.response.ValidationResponse;
//import com.sevenine.usuario.repository.SequenceCadastroRepository;
//import com.sevenine.usuario.repository.data.SequenceCadastro;
//import com.sevenine.usuario.services.DocumentoService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Component
//public class DocumentoServiceImpl implements DocumentoService {
//
//    private final SequenceCadastroRepository repository;
//
//    @Override
//    public ConsultaUsuarioResponse consulta(long idDocumento) {
//        return repository.findById(idDocumento)
//                .map(sequenceCadastro -> ConsultaUsuarioResponse.builder()
//                        .id(sequenceCadastro.getId())
//                        .status(sequenceCadastro.getStatus().name())
//                        .build())
//                .orElse(ConsultaUsuarioResponse.builder().build());
//    }
//
//    @Override
//    public ValidationResponse atualizarStatus(long idDocumento, StatusCadastro statusCadastro) {
//        Optional<SequenceCadastro> optional = repository.findById(idDocumento);
//        if (!optional.isPresent()) {
//            return ValidationResponse.builder().build();
//        }
//        SequenceCadastro sequenceCadastro = optional.get();
//        sequenceCadastro.setStatus(statusCadastro);
//        SequenceCadastro sequenceCadastroAtualizado = repository.save(sequenceCadastro);
//        return ValidationResponse.builder()
//                .id(sequenceCadastroAtualizado.getId())
//                .build();
//    }
//
//}
