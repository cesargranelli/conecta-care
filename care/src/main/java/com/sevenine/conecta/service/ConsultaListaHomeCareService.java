package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.HomeCareResponse;

import java.util.List;

public interface ConsultaListaHomeCareService {
    List<HomeCareResponse> consultar();
}
