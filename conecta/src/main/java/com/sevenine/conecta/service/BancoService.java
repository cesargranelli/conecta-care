package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaBancoResponse;

import java.util.List;

public interface BancoService {
    List<ConsultaBancoResponse> consultar();
}
