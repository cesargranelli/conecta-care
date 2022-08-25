package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.TelefoneRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaTelefoneResponse;

public interface CadastraAtualizaTelefoneUseCase {
    CadastraAtualizaTelefoneResponse executar(TelefoneRequest request);
}
