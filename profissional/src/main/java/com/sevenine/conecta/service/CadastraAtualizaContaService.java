package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaService {
    CadastraAtualizaContaResponse salvar(ContaRequest request);
}
