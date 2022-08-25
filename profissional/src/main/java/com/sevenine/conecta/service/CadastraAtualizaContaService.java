package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.ContaRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaContaResponse;

public interface CadastraAtualizaContaService {
    CadastraAtualizaContaResponse salvar(ContaRequest request);
}
