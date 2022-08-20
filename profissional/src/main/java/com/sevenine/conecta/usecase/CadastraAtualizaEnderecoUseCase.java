package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEnderecoResponse;

public interface CadastraAtualizaEnderecoUseCase {
    CadastraAtualizaEnderecoResponse executar(EnderecoRequest request);
}
