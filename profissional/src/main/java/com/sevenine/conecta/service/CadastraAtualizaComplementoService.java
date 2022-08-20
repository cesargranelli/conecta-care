package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaComplementoResponse;

public interface CadastraAtualizaComplementoService {
    CadastraAtualizaComplementoResponse salvar(ComplementoRequest request);
}
