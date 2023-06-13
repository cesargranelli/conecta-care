package com.sevenine.usuario.adapter.controller;

import com.google.gson.Gson;
import com.sevenine.usuario.entity.ConsultaUsuario;
import com.sevenine.usuario.adapter.controller.data.request.EsqueciMinhaSenhaRequest;
import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;
import com.sevenine.usuario.adapter.controller.data.response.EsqueciMinhaSenhaResponse;
import com.sevenine.usuario.usecase.ConsultaUsuarioUseCase;
import com.sevenine.usuario.usecase.SolicitaAlteracaoSenhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("login")
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final ConsultaUsuarioUseCase consultaUsuarioUseCase;
    private final SolicitaAlteracaoSenhaUseCase solicitaAlteracaoSenhaUseCase;

    private final Gson gson;

    @GetMapping
    public ResponseEntity<?> find() {
        ConsultaUsuario consultaUsuario =
                gson.fromJson(SecurityContextHolder.getContext().getAuthentication().getName(), ConsultaUsuario.class);
        ConsultaUsuarioResponse response = consultaUsuarioUseCase.executar(consultaUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> passwordForget(@RequestBody EsqueciMinhaSenhaRequest request) {
        EsqueciMinhaSenhaResponse response = solicitaAlteracaoSenhaUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
