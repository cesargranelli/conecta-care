package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEnderecoResponse;

public interface CadastraAtualizaEnderecoService {
    CadastraAtualizaEnderecoResponse salvar(EnderecoRequest request);
}
