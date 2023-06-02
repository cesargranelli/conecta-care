package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.data.request.tratamento.AdicionaTratamentoRequest;
import com.sevenine.conecta.adapter.controller.data.request.tratamento.EncerraTratamentoRequest;
import com.sevenine.conecta.adapter.controller.data.response.tratamento.ConsultaTratamentoResponse;
import com.sevenine.conecta.adapter.controller.data.response.tratamento.ListaTratamentoEmAbertoResponse;
import com.sevenine.conecta.adapter.controller.data.response.tratamento.ProntuarioResponse;
import com.sevenine.conecta.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping(path = "tratamentos")
@RestController
public class TratamentoController {

    private final AdicionaTratamentoUseCase adicionaTratamentoUseCase;
    private final ConsultaProntuarioUseCase consultaProntuarioUseCase;
    private final ConsultaTratamentoUseCase consultaTratamentoUseCase;
    private final ConsultaTratamentoEmAbertoUseCase consultaTratamentoEmAbertoUseCase;
    private final ListaTratamentoEmAbertoUseCase listaTratamentoEmAbertoUseCase;
    private final EncerraTratamentoUseCase encerraTratamentoUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adiciona(@RequestBody @Valid AdicionaTratamentoRequest request) {
        adicionaTratamentoUseCase.executar(request);
    }

    @GetMapping("prontuario")
    public ResponseEntity<ProntuarioResponse> prontuario(
            @RequestHeader("idPaciente") Long pacienteId,
            @RequestHeader("idHomeCare") Long homeCareId) {
        return ResponseEntity.ok(consultaProntuarioUseCase.executar(pacienteId, homeCareId));
    }

    @GetMapping("{tratamentoId}")
    public ResponseEntity<ConsultaTratamentoResponse> consulta(@PathVariable Long tratamentoId) {
        return ResponseEntity.ok(consultaTratamentoUseCase.executar(tratamentoId));
    }

    @GetMapping("aberto")
    public ResponseEntity<List<ListaTratamentoEmAbertoResponse>> listarEmAberto(@RequestHeader Long homeCareId) {
        return ResponseEntity.ok(listaTratamentoEmAbertoUseCase.executar(homeCareId));
    }

    @GetMapping("aberto/paciente")
    public ResponseEntity<ConsultaTratamentoResponse> emAbertoPaciente(@RequestHeader Long pacienteId, @RequestHeader Long homeCareId) {
        return ResponseEntity.ok(consultaTratamentoEmAbertoUseCase.executar(pacienteId, homeCareId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("encerramento")
    public void encerramento(@RequestBody @Valid EncerraTratamentoRequest request) {
        encerraTratamentoUseCase.executar(request);
    }

}

