package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaBancoResponse;

import java.util.List;

public interface BancoService {
    List<ConsultaBancoResponse> consultar();
}
