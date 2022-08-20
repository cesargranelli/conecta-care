package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaTelefoneResponse;

public interface CadastraAtualizaTelefoneService {
    CadastraAtualizaTelefoneResponse salvar(TelefoneRequest request);
}
