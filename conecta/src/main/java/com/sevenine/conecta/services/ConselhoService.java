package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaConselhoResponse;

import java.util.List;

public interface ConselhoService {
    List<ConsultaConselhoResponse> consultar();
}
