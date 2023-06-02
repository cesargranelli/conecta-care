package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareResponse;

import java.util.List;

public interface HomeCareService {
    HomeCareCadastroResponse cadastrar(HomeCareRequest request);
    void alterar(HomeCareRequest request);
    HomeCareResponse consultar(Long id);
    List<HomeCareResponse> findAll();
}
