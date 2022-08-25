package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEscolaridadeResponse;

public interface CadastraAtualizaEscolaridadeService {
    CadastraAtualizaEscolaridadeResponse salvar(EscolaridadeRequest request);
}
