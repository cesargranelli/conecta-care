package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.request.ProfissionalRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaProfissionalResponse;
import com.sevenine.conecta.services.BuscaDocumentoProfissionalService;
import com.sevenine.conecta.services.CadastraAtualizaProfissionalService;
import com.sevenine.conecta.usecase.CadastraAtualizaProfissionalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastraAtualizaProfissionalUseCaseImpl implements CadastraAtualizaProfissionalUseCase {

    private final BuscaDocumentoProfissionalService buscaDocumentoProfissionalService;
    private final CadastraAtualizaProfissionalService service;

    @Override
    public CadastraAtualizaProfissionalResponse executar(ProfissionalRequest request) {
        request.setCpf(buscaDocumentoProfissionalService.buscar(request.getId()));
        return service.salvar(request);
    }

}
