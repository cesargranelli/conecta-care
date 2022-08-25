package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.request.CarreiraRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaCarreiraMapper;
import com.sevenine.conecta.repository.CarreiraRepository;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.services.CadastraAtualizaCarreiraService;
import com.sevenine.conecta.services.ConsultaConselhoService;
import com.sevenine.conecta.services.ConsultaEstadoService;
import com.sevenine.conecta.services.ConsultaTransporteService;
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
