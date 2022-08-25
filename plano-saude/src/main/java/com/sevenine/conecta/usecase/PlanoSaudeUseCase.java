package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeResponse;
import com.sevenine.conecta.services.PlanoSaudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlanoSaudeUseCase {

    private final PlanoSaudeService planoSaudeService;

    public PlanoSaudeCadastroResponse cadastrar(PlanoSaudeRequest request) {
        return planoSaudeService.cadastrar(request);
    }

    public void alterar(PlanoSaudeRequest request) {
        planoSaudeService.alterar(request);
    }

    public PlanoSaudeResponse consultar(Long idPlanoSaude) {
        return planoSaudeService.consultar(idPlanoSaude);
    }

    public List<PlanoSaudeResponse> listarMatriz() {
        return planoSaudeService.listarMatriz();
    }

}
