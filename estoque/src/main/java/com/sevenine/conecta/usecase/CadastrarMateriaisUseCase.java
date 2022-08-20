package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.service.CadastrarMateriaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarMateriaisUseCase {

    private final CadastrarMateriaisService service;

    public void cadastro(CadastroMaterialRequest request) {

        service.executar(request);

    }
}
