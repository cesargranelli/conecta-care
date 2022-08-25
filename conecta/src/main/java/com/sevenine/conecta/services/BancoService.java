package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaBancoResponse;

import java.util.List;

public interface BancoService {
    List<ConsultaBancoResponse> consultar();
}
