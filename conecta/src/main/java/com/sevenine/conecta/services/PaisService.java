package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaPaisResponse;

import java.util.List;

public interface PaisService {
    List<ConsultaPaisResponse> consultar();
}
