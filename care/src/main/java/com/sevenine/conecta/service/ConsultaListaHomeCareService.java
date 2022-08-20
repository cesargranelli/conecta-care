package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.HomeCareResponse;

import java.util.List;

public interface ConsultaListaHomeCareService {
    List<HomeCareResponse> consultar();
}
