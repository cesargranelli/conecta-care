package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.ContaRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaService {
    CadastraAtualizaContaResponse salvar(ContaRequest request);
}
