package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.controller.data.response.HomeCareResponse;

import java.util.List;

public interface HomeCareService {
    HomeCareCadastroResponse cadastrar(HomeCareRequest request);
    void alterar(HomeCareRequest request);
    HomeCareResponse consultar(Long id);
    List<HomeCareResponse> findAll();
}
