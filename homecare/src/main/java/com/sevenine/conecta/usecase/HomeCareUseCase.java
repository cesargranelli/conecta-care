package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.controller.data.response.HomeCareResponse;
import com.sevenine.conecta.service.HomeCareService;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HomeCareUseCase {

    private final HomeCareService homeCareService;

    public HomeCareCadastroResponse cadastrar(HomeCareRequest request) {
        return homeCareService.cadastrar(request);
    }

    public void alterar(HomeCareRequest request) {
        homeCareService.alterar(request);
    }

    public HomeCareResponse consultar(Long idHomeCare) {
        return homeCareService.consultar(idHomeCare);
    }

    public List<HomeCareResponse> findAll() {
        return homeCareService.findAll();
    }
    
}
