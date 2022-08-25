package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaPaisResponse;

import java.util.List;

public interface PaisService {
    List<ConsultaPaisResponse> consultar();
}
