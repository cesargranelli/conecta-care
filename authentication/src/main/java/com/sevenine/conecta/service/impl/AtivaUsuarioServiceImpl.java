package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.repository.SequenceCadastroRepository;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.service.AtivaUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtivaUsuarioServiceImpl implements AtivaUsuarioService {

    private final SequenceCadastroRepository sequenceCadastroRepository;

    @Override
    public void executar(Long profissionalId) {
        Optional<SequenceCadastro> optional = sequenceCadastroRepository.findById(profissionalId);
        if (optional.isPresent()) {
            SequenceCadastro sequenceCadastro = optional.get();
            sequenceCadastro.setStatus(StatusCadastro.COMPLETO);
            sequenceCadastroRepository.flush();
        }
    }

}
