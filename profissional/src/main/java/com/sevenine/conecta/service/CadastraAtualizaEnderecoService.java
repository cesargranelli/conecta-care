package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.EnderecoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaEnderecoResponse;

public interface CadastraAtualizaEnderecoService {
    CadastraAtualizaEnderecoResponse salvar(EnderecoRequest request);
}
