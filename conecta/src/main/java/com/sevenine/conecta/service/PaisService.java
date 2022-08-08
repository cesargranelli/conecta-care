package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaPaisResponse;

import java.util.List;

public interface PaisService {
    List<ConsultaPaisResponse> consultar();
}
