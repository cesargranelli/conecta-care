//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.enumerator.StatusCadastro;
//import com.sevenine.usuario.repository.SequenceCadastroRepository;
//import com.sevenine.usuario.repository.data.SequenceCadastro;
//import com.sevenine.usuario.services.AtivaUsuarioService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class AtivaUsuarioServiceImpl implements AtivaUsuarioService {
//
//    private final SequenceCadastroRepository sequenceCadastroRepository;
//
//    @Override
//    public void executar(Long profissionalId) {
//        Optional<SequenceCadastro> optional = sequenceCadastroRepository.findById(profissionalId);
//        if (optional.isPresent()) {
//            SequenceCadastro sequenceCadastro = optional.get();
//            sequenceCadastro.setStatus(StatusCadastro.COMPLETO);
//            sequenceCadastroRepository.flush();
//        }
//    }
//
//}
