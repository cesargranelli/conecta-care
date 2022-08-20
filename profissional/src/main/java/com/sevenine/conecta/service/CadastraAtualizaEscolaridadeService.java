package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEscolaridadeResponse;

public interface CadastraAtualizaEscolaridadeService {
    CadastraAtualizaEscolaridadeResponse salvar(EscolaridadeRequest request);
}
