package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaCarreiraMapper;
import com.sevenine.conecta.repository.CarreiraRepository;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.service.CadastraAtualizaCarreiraService;
import com.sevenine.conecta.service.ConsultaConselhoService;
import com.sevenine.conecta.service.ConsultaEstadoService;
import com.sevenine.conecta.service.ConsultaTransporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaCarreiraServiceImpl implements CadastraAtualizaCarreiraService {

    private final CadastraAtualizaCarreiraMapper mapper;

    private final CarreiraRepository repository;

    private final ConsultaConselhoService conselhoService;

    private final ConsultaTransporteService transporteService;

    private final ConsultaEstadoService estadoService;

    @Override
    public CadastraAtualizaCarreiraResponse salvar(CarreiraRequest request) {
        Optional<Carreira> optional = repository.findByProfissionalId(request.getProprietarioId());

        if (optional.isPresent()) {
            request.setId(optional.get().getId());
            repository.flush();
        }

        Carreira carreira = mapper.toEntityData(request);

        return mapper.fromEntityData(repository.saveAndFlush(carreira));

    }

}
