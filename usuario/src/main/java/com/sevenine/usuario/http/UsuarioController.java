package com.sevenine.usuario.adapter.controller;

import com.google.gson.Gson;
import com.sevenine.usuario.entity.ConsultaUsuario;
import com.sevenine.usuario.entity.ValidacaoUsuario;
import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.usuario.adapter.controller.data.response.CadastroResponse;
import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;
import com.sevenine.usuario.adapter.controller.data.response.ValidationResponse;
import com.sevenine.usuario.usecase.AtivaUsuarioUseCase;
import com.sevenine.usuario.usecase.CadastraUsuarioUseCase;
import com.sevenine.usuario.usecase.ConsultaUsuarioUseCase;
import com.sevenine.usuario.usecase.ValidaUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("usuarios")
@RequiredArgsConstructor
@RestController
public class UsuarioController {

    private final CadastraUsuarioUseCase cadastraUsuarioUseCase;
    private final ConsultaUsuarioUseCase consultaUsuarioUseCase;
    private final ValidaUsuarioUseCase validaUsuarioUseCase;
    private final AtivaUsuarioUseCase ativaUsuarioUseCase;

    private final Gson gson;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CadastroUsuarioRequest request) {
        try {
            String token = cadastraUsuarioUseCase.executar(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(CadastroResponse.builder().token(token).build());
        } catch (SQLException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> find() {
        ConsultaUsuario consultaUsuario =
                gson.fromJson(SecurityContextHolder.getContext().getAuthentication().getName(), ConsultaUsuario.class);
        ConsultaUsuarioResponse response = consultaUsuarioUseCase.executar(consultaUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("validacao")
    public ResponseEntity<?> validation() {
        ValidacaoUsuario validacaoUsuario =
                gson.fromJson(SecurityContextHolder.getContext().getAuthentication().getName(), ValidacaoUsuario.class);
        ValidationResponse response = validaUsuarioUseCase.executar(validacaoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("ativacao")
    public void activation(@RequestHeader Long sequenceCadastroId) {
        ativaUsuarioUseCase.executar(sequenceCadastroId);
    }

}
