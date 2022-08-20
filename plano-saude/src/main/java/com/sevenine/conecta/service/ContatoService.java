package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.ContatoRequest;
import com.sevenine.conecta.controller.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controller.data.response.ContatoResponse;

public interface ContatoService {
    ContatoCadastroResponse cadastrar(ContatoRequest request);
    void alterar(ContatoRequest request);
    ContatoResponse consultar(Long idPlanoSaude);
}
