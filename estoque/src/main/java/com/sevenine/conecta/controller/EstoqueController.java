package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.usecase.CadastrarMateriaisUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping(path = "estoque")
@RestController
public class EstoqueController {

    private final CadastrarMateriaisUseCase cadastrarMateriaisUseCase;

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PostMapping(value = "materiais")
    public void cadastro(@RequestBody @Valid CadastroMaterialRequest request) {
        cadastrarMateriaisUseCase.cadastro(request);
    }

}
