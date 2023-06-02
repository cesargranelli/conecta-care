package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEscolaridadeResponse;

public interface CadastraAtualizaEscolaridadeService {
    CadastraAtualizaEscolaridadeResponse salvar(EscolaridadeRequest request);
}
