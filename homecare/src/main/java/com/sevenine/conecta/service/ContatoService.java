package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.ContatoRequest;
import com.sevenine.conecta.adapter.controller.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.ContatoResponse;

public interface ContatoService {
    ContatoCadastroResponse cadastrar(ContatoRequest request);
    void alterar(ContatoRequest request);
    ContatoResponse consultar(Long idHomeCare);
}
