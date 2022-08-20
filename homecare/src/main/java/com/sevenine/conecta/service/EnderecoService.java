package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.controller.data.response.EnderecoResponse;

public interface EnderecoService {
    EnderecoCadastroResponse cadastrar(EnderecoRequest request);
    void alterar(EnderecoRequest request);
    EnderecoResponse consultar(Long idHomeCare);
}
