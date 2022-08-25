package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.ComplementoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaComplementoResponse;

public interface CadastraAtualizaComplementoService {
    CadastraAtualizaComplementoResponse salvar(ComplementoRequest request);
}
