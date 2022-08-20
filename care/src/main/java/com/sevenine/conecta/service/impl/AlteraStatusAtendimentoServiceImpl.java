package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.AtendimentoSituacaoRepository;
import com.sevenine.conecta.repository.StatusAtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import com.sevenine.conecta.repository.data.StatusAtendimento;
import com.sevenine.conecta.service.AlteraStatusAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlteraStatusAtendimentoServiceImpl implements AlteraStatusAtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final StatusAtendimentoRepository statusAtendimentoRepository;
    private final AtendimentoSituacaoRepository atendimentoSituacaoRepository;

    @Override
    public void alterar(String status, Long atendimentoId) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(atendimentoId);
        Optional<StatusAtendimento> statusAtendimento = statusAtendimentoRepository.findByStatusEnum(status);

        if(!atendimento.isPresent())
            throw new NaoLocalizadoException("Atendimento não localizado", HttpStatus.BAD_REQUEST);

        if(!statusAtendimento.isPresent())
            throw new NaoLocalizadoException("Status de atendimento não localizado", HttpStatus.BAD_REQUEST);

        AtendimentoSituacao novoStatus = new AtendimentoSituacao();
        novoStatus.setStatus(statusAtendimento.get());
        novoStatus.setAtendimento(atendimento.get());
        novoStatus.setDataHora(LocalDateTime.now());
        atendimentoSituacaoRepository.save(novoStatus);
    }

}
