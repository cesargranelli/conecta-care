package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controller.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controller.data.response.PlanoSaudeResponse;

import java.util.List;

public interface PlanoSaudeService {
    PlanoSaudeCadastroResponse cadastrar(PlanoSaudeRequest request);
    void alterar(PlanoSaudeRequest request);
    PlanoSaudeResponse consultar(Long id);
    List<PlanoSaudeResponse> listarMatriz();
}
