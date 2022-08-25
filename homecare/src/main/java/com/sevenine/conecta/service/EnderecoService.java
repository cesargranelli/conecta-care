package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.EnderecoRequest;
import com.sevenine.conecta.controllers.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.controllers.data.response.EnderecoResponse;

public interface EnderecoService {
    EnderecoCadastroResponse cadastrar(EnderecoRequest request);
    void alterar(EnderecoRequest request);
    EnderecoResponse consultar(Long idHomeCare);
}
