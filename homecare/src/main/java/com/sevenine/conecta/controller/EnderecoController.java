package com.sevenine.conecta.controller;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.usecase.EnderecoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "homecares/{idHomeCare}/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoUseCase enderecoUseCase;

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody EnderecoRequest request) {
        EnderecoCadastroResponse response = enderecoUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@RequestBody EnderecoRequest request) {
        enderecoUseCase.alterar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> consulta(@PathVariable Long idHomeCare) {
        EnderecoResponse response = enderecoUseCase.consultar(idHomeCare);
        return ResponseEntity.ok().body(response);
    }

}
