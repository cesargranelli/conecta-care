package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeResponse;

import java.util.List;

public interface PlanoSaudeService {
    PlanoSaudeCadastroResponse cadastrar(PlanoSaudeRequest request);
    void alterar(PlanoSaudeRequest request);
    PlanoSaudeResponse consultar(Long id);
    List<PlanoSaudeResponse> listarMatriz();
}
