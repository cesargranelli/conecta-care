package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeResponse;
import com.sevenine.conecta.usecase.PlanoSaudeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "planos-saude")
@RequiredArgsConstructor
public class PlanoSaudeController {

    private final PlanoSaudeUseCase planoSaudeUseCase;

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody PlanoSaudeRequest request) {
        PlanoSaudeCadastroResponse response = planoSaudeUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@RequestBody PlanoSaudeRequest request) {
        planoSaudeUseCase.alterar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consulta(@PathVariable Long id) {
        PlanoSaudeResponse response = planoSaudeUseCase.consultar(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("matriz")
    public ResponseEntity<?> listaMatriz() {
        List<PlanoSaudeResponse> response = planoSaudeUseCase.listarMatriz();
        return ResponseEntity.ok().body(response);
    }

}
