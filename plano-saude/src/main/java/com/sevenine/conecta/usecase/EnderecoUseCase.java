package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.adapter.controller.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoUseCase {

    private final EnderecoService enderecoService;

    public EnderecoCadastroResponse cadastrar(EnderecoRequest request) {
        return enderecoService.cadastrar(request);
    }

    public void alterar(EnderecoRequest request) {
        enderecoService.alterar(request);
    }

    public EnderecoResponse consultar(Long idPlanoSaude) {
        return enderecoService.consultar(idPlanoSaude);
    }

}
