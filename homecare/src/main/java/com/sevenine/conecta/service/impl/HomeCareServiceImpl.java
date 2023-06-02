package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareResponse;
import com.sevenine.conecta.exception.HomeCareNaoEncontradaException;
import com.sevenine.conecta.repository.HomeCareRepository;
import com.sevenine.conecta.repository.data.Especialidade;
import com.sevenine.conecta.repository.data.HomeCare;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import com.sevenine.conecta.services.DocumentoConsultaService;
import com.sevenine.conecta.services.HomeCareService;
import com.sevenine.conecta.services.converter.HomeCareServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HomeCareServiceImpl implements HomeCareService {

    private final HomeCareServiceConverter converter;

    private final HomeCareRepository repository;

    private final DocumentoConsultaService service;

    @Override
    public HomeCareCadastroResponse cadastrar(HomeCareRequest request) {
        HomeCare homecare = converter.toEntity(request);
        return converter.toResponse(repository.save(homecare).getId());
    }

    @Override
    public void alterar(HomeCareRequest request) {
        Optional<HomeCare> homeCareOptional = repository.findById(request.getId());
        if (homeCareOptional.isPresent()) {
            homeCareOptional.get().atualizarHomeCare(converter.toEntity(request));
            repository.flush();
        } else {
            repository.save(converter.toEntity(request));
        }
    }

    @Override
    public HomeCareResponse consultar(Long id) {
        try {
            Optional<HomeCare> optional = repository.findById(id);
            return converter.toResponse(optional.orElse(HomeCare.builder()
                    .cnpj(service.consultar(id).getDocumento())
                    .tipoEmpresa(TipoEmpresa.builder().build())
                    .especialidades(Collections.singletonList(Especialidade.builder().build()))
                    .build()));
        } catch (HomeCareNaoEncontradaException | NullPointerException e) {
            throw new HomeCareNaoEncontradaException(
                    "Home Care não encontrada", HttpStatus.NOT_FOUND
            );
        }
    }

    @Override
    public List<HomeCareResponse> findAll() {
        return HomeCareResponse.ofEntities(repository.findAll());
    }
}
