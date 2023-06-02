package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEscolaridadeResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaEscolaridadeMapper;
import com.sevenine.conecta.repository.EscolaridadeRepository;
import com.sevenine.conecta.repository.data.Escolaridade;
import com.sevenine.conecta.services.CadastraAtualizaEscolaridadeService;
import com.sevenine.conecta.services.ConsultaInstrucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaEscolaridadeServiceImpl implements CadastraAtualizaEscolaridadeService {

    private final CadastraAtualizaEscolaridadeMapper mapper;

    private final EscolaridadeRepository repository;

    private final ConsultaInstrucaoService instrucaoService;

    @Override
    public CadastraAtualizaEscolaridadeResponse salvar(EscolaridadeRequest request) {

        Optional<Escolaridade> optional = repository.findByProfissionalId(request.getProprietarioId());
        if (!isNull(request.getInstituicaoEnsino())) {
            request.getInstituicaoEnsino().stream().map(String::toString).collect(java.util.stream.Collectors.joining("\",\"", "[\"", "\"]"));
        }

        if (!optional.isPresent()) {
            Escolaridade escolaridade = mapper.toEntityData(request);
            escolaridade.setInstrucao(instrucaoService.consultar(request.getInstrucao().getId()));
            return mapper.fromEntityData(repository.saveAndFlush(escolaridade));
        } else {
            Escolaridade escolaridade = optional.get();
            mapper.updateEscolaridade(request, escolaridade);
            escolaridade.setInstrucao(instrucaoService.consultar(request.getInstrucao().getId()));
            repository.flush();
            return mapper.fromEntityData(escolaridade);
        }

    }

}
