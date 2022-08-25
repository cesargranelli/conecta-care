package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.EnderecoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEnderecoResponse;

public interface CadastraAtualizaEnderecoUseCase {
    CadastraAtualizaEnderecoResponse executar(EnderecoRequest request);
}
