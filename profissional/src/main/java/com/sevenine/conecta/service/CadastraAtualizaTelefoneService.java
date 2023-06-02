package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaTelefoneResponse;

public interface CadastraAtualizaTelefoneService {
    CadastraAtualizaTelefoneResponse salvar(TelefoneRequest request);
}
