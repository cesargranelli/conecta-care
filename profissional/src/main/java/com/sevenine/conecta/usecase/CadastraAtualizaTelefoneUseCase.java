package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaTelefoneResponse;

public interface CadastraAtualizaTelefoneUseCase {
    CadastraAtualizaTelefoneResponse executar(TelefoneRequest request);
}
