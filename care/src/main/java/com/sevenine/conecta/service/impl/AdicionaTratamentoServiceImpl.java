package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.tratamento.AdicionaTratamentoRequest;
import com.sevenine.conecta.mapper.tratamento.AdicionaTratamentoMapper;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.service.AdicionaTratamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdicionaTratamentoServiceImpl implements AdicionaTratamentoService {

    private final AdicionaTratamentoMapper mapper;

    private final TratamentoRepository repository;

    @Override
    public Long adicionar(AdicionaTratamentoRequest request) {
        Tratamento tratamento = mapper.toEntityData(request);

        return repository.save(tratamento).getId();
    }

}
