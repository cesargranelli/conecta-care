package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaComplementoResponse;

public interface CadastraAtualizaComplementoService {
    CadastraAtualizaComplementoResponse salvar(ComplementoRequest request);
}
