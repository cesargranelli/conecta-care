package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaConselhoResponse;

import java.util.List;

public interface ConselhoService {
    List<ConsultaConselhoResponse> consultar();
}
