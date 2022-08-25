package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.TelefoneRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaTelefoneResponse;

public interface CadastraAtualizaTelefoneService {
    CadastraAtualizaTelefoneResponse salvar(TelefoneRequest request);
}
