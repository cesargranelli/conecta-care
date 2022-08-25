package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.data.request.ContatoRequest;
import com.sevenine.conecta.controllers.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controllers.data.response.ContatoResponse;
import com.sevenine.conecta.usecase.ContatoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "homecares/{idHomeCare}/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoUseCase contatoUseCase;

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody ContatoRequest request) {
        ContatoCadastroResponse response = contatoUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@RequestBody ContatoRequest request) {
        contatoUseCase.alterar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> consulta(@PathVariable Long idHomeCare) {
        ContatoResponse response = contatoUseCase.consultar(idHomeCare);
        return ResponseEntity.ok().body(response);
    }

}
