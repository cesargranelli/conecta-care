package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.controllers.data.request.atendimento.BaixaRequest;
import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoCheckResponse;
import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoPacienteResponse;
import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.controllers.data.response.atendimento.ConsultaAtendimentoDetalheResponse;
import com.sevenine.conecta.services.data.request.atendimento.AtendimentoPreviewPara;
import com.sevenine.conecta.services.data.response.AtendimentoPreviewResponse;
import com.sevenine.conecta.services.data.response.ProfissionalAtendimentoResponse;
import com.sevenine.conecta.usecase.AdicionaAtendimentoUseCase;
import com.sevenine.conecta.usecase.AlteraStatusAtendimentoUseCase;
import com.sevenine.conecta.usecase.BaixaAtendimentoUseCase;
import com.sevenine.conecta.usecase.ConsultaAtendimentoCheckUseCase;
import com.sevenine.conecta.usecase.ConsultaAtendimentoDetalheUseCase;
import com.sevenine.conecta.usecase.ConsultaAtendimentoPorProfissionalUseCase;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoPacienteUseCase;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoPreviewUseCase;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoResumoUseCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "atendimentos")
@RestController
public class AtendimentoController {

    private final AdicionaAtendimentoUseCase adicionaAtendimentoUseCase;
    private final ConsultaListaAtendimentoResumoUseCase consultaListaAtendimentoResumoUseCase;
    private final ConsultaAtendimentoDetalheUseCase consultaAtendimentoDetalheUseCase;
    private final ConsultaAtendimentoPorProfissionalUseCase consultaAtendimentoPorProfissionalUseCase;
    private final AlteraStatusAtendimentoUseCase alteraStatusAtendimentoUseCase;
    private final ConsultaListaAtendimentoPacienteUseCase consultaListaAtendimentoPacienteUseCase;
    private final ConsultaAtendimentoCheckUseCase consultaAtendimentoCheckUseCase;
    private final BaixaAtendimentoUseCase baixaAtendimentoUseCase;
    private final ConsultaListaAtendimentoPreviewUseCase consultaListaAtendimentoPreviewUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adiciona(@RequestBody @Valid AdicionaAtendimentoRequest request) {
        adicionaAtendimentoUseCase.executar(request);
    }

    @GetMapping("resumo")
    public ResponseEntity<List<AtendimentoResumoResponse>> resumo(
            @RequestHeader Long idHomeCare,
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            @RequestHeader(required = false) LocalDate dataConsulta) {
        return ResponseEntity.ok(consultaListaAtendimentoResumoUseCase.executar(idHomeCare, dataConsulta));
    }

    @GetMapping("/{atendimentoId}")
    public ResponseEntity<ConsultaAtendimentoDetalheResponse> atendimento(@PathVariable Long atendimentoId) {
        return ResponseEntity.ok(consultaAtendimentoDetalheUseCase.executar(atendimentoId));
    }

    @GetMapping("profissional")
    public ResponseEntity<List<ProfissionalAtendimentoResponse>> atendimentoPorProfissional(
            @RequestHeader("profissionalId") Long profissionalId,
            @RequestHeader("dataAtendimento") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataAtendimento) {
        return ResponseEntity.ok(consultaAtendimentoPorProfissionalUseCase.executar(profissionalId, dataAtendimento));
    }

    @PostMapping("status")
    public ResponseEntity<Void> alteraStatus(
            @RequestHeader("status") String status,
            @RequestHeader("atendimentoId") Long atendimentoId) {
        alteraStatusAtendimentoUseCase.executar(status, atendimentoId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("paciente")
    public ResponseEntity<List<AtendimentoPacienteResponse>> atendimentosPaciente(
            @RequestHeader Long pacienteId, @RequestHeader @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataConsulta) {
        return ResponseEntity.ok(consultaListaAtendimentoPacienteUseCase.executar(pacienteId, dataConsulta));
    }

    @GetMapping("profissional/check")
    public ResponseEntity<List<AtendimentoCheckResponse>> atendimentoCheck(
            @RequestHeader Long profissionalId, @RequestHeader @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<LocalDate> dataAtendimento) {
        return ResponseEntity.ok(consultaAtendimentoCheckUseCase.executar(dataAtendimento, profissionalId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("baixa")
    public void baixa(@RequestBody BaixaRequest request) {
        baixaAtendimentoUseCase.executar(request);
    }

    @GetMapping("preview")
    public ResponseEntity<List<AtendimentoPreviewResponse>> preview(
            @RequestHeader(required = false) String cpfProfissional,
            @RequestHeader(required = false) String cpfPaciente,
            @RequestHeader(required = false) String areaAtendimentoId,
            @RequestHeader(required = false) String statusAtendimentoId,
            @RequestHeader(required = false) String homeCareId,
            @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestHeader(required = false) LocalDate periodoDe,
            @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestHeader(required = false) LocalDate periodoAte) {
        
        return ResponseEntity.ok(
            consultaListaAtendimentoPreviewUseCase.consultar(
                    cpfProfissional, cpfPaciente, areaAtendimentoId, statusAtendimentoId, homeCareId,
                    periodoDe, periodoAte)
        );
    }
    
    @GetMapping("preview/file")
    public ResponseEntity<Resource> previewPdf(
            @RequestHeader(required = false) AtendimentoPreviewPara gerarPara,
            @RequestHeader(required = false) String cpfProfissional,
            @RequestHeader(required = false) String cpfPaciente,
            @RequestHeader(required = false) String areaAtendimentoId,
            @RequestHeader(required = false) String statusAtendimentoId,
            @RequestHeader(required = false) String homeCareId,
            @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestHeader(required = false) LocalDate periodoDe,
            @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestHeader(required = false) LocalDate periodoAte) {

        File file = consultaListaAtendimentoPreviewUseCase.consultarFile(gerarPara, cpfProfissional, cpfPaciente, areaAtendimentoId, statusAtendimentoId, homeCareId, periodoDe, periodoAte);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // .headers(headers)
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);        
    }
    
}

