package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEnderecoResponse;

public interface CadastraAtualizaEnderecoService {
    CadastraAtualizaEnderecoResponse salvar(EnderecoRequest request);
}
