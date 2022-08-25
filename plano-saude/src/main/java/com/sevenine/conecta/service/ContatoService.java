package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.ContatoRequest;
import com.sevenine.conecta.controllers.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controllers.data.response.ContatoResponse;

public interface ContatoService {
    ContatoCadastroResponse cadastrar(ContatoRequest request);
    void alterar(ContatoRequest request);
    ContatoResponse consultar(Long idPlanoSaude);
}
