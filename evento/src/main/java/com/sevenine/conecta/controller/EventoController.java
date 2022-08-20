package com.connecta.evento.controller;

import com.connecta.evento.controller.data.request.EventoRequest;
import com.connecta.evento.controller.data.response.EnvioResponse;
import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(path = "eventos")
@RestController
public class EventoController {

    private final EventoCadastraUseCase eventoCadastraUseCase;
    private final EventoEnviaUseCase eventoEnviaUseCase;
    private final EventoEncerraUseCase eventoEncerraUseCase;
    private final EventoFuturoUseCase eventoFuturoUseCase;
    private final EventoConsultaUseCase eventoConsultaUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastra(@RequestBody EventoRequest request) {
        eventoCadastraUseCase.executar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{idEvento}/enviar")
    public ResponseEntity<EnvioResponse> envia(@PathVariable long idEvento) {
        return ResponseEntity.ok(eventoEnviaUseCase.executar(idEvento));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{idEvento}")
    public void encerra(@PathVariable long idEvento, @RequestHeader String usuario) {
        eventoEncerraUseCase.executar(idEvento, usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<EventoResponse>> proximos() {
        return ResponseEntity.ok(eventoFuturoUseCase.executar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{idEvento}")
    public ResponseEntity<EventoResponse> pesquisa(@PathVariable long idEvento) {
        return ResponseEntity.ok(eventoConsultaUseCase.executar(idEvento));
    }

}

