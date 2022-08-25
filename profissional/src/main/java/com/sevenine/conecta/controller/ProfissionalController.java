package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.data.request.*;
import com.sevenine.conecta.controllers.data.response.*;
import com.sevenine.conecta.usecase.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfissionalController {

    private final CadastraAtualizaProfissionalUseCase cadastraAtualizaProfissionalUseCase;
    private final CadastraAtualizaEnderecoUseCase cadastraAtualizaEnderecoUseCase;
    private final ProfissionalUseCase profissionalUseCase;
    private final ConsultaEnderecoUseCase consultaEnderecoUseCase;
    private final ProfissionalFiltroEspecialidadeUseCase filtroEspecialidadeUseCase;
    private final ProfissionalFiltroDadosSmsUseCase dadosSmsUseCase;
    private final CadastraAtualizaTelefoneUseCase cadastraAtualizaTelefoneUseCase;
    private final ConsultaTelefoneUseCase consultaTelefoneUseCase;
    private final CadastraAtualizaContaUseCase cadastraAtualizaContaUseCase;
    private final ConsultaContaUseCase consultaContaUseCase;
    private final CadastraAtualizaComplementoUseCase cadastraAtualizaComplementoUseCase;
    private final ConsultaComplementoUseCase consultaComplementoUseCase;
    private final CadastraAtualizaExperienciaUseCase cadastraAtualizaExperienciaUseCase;
    private final ListaProfissionalUseCase listaProfissionalUseCase;
    private final ConsultaExperienciaUseCase consultaExperienciaUseCase;
    private final CadastraAtualizaCarreiraUseCase cadastraAtualizaCarreiraUseCase;
    private final ConsultaCarreiraUseCase consultaCarreiraUseCase;
    private final CadastraAtualizaEscolaridadeUseCase cadastraAtualizaEscolaridadeUseCase;
    private final ConsultaEscolaridadeUseCase consultaEscolaridadeUseCase;
    private final ConsultaProfissionalPorCpfUseCase consultaProfissionalPorCpfUseCase;
    private final ConsultaProfissionalCompletoUseCase consultaProfissionalCompletoUseCase;
    private final ConsultaProfissionalPorNomeUseCase consultaProfissionalPorNomeUseCase;

    @PostMapping("profissionais")
    public ResponseEntity<?> cadastraOuAtualiza(@RequestBody ProfissionalRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaProfissionalUseCase.executar(request));
    }

    @GetMapping("profissionais/{idProfissional}")
    public ResponseEntity<?> consultaProfissional(@PathVariable Long idProfissional) {
        return ResponseEntity.ok().body(profissionalUseCase.consultar(idProfissional));
    }

    @GetMapping("profissionais/cpf/{numeroCpf}")
    public ResponseEntity<ProfissionalResponse> consultaProfissionalPorCpf(@PathVariable String numeroCpf) {
        return ResponseEntity.ok().body(consultaProfissionalPorCpfUseCase.executar(StringUtils.leftPad(numeroCpf, 11, "0")));
    }

    @GetMapping("profissionais/filtro/especialidade")
    public ResponseEntity<?> listaProfissionaisPorEspecialidade(@RequestHeader("especialidades") List<Long> idsEspecialidades) {
        return ResponseEntity.ok(filtroEspecialidadeUseCase.executar(idsEspecialidades));
    }

    @GetMapping("profissionais/filtro/dados/sms")
    public ResponseEntity<?> dadosSms(
            @RequestHeader("especialidades") List<Long> idsEspecialidades, @RequestHeader("estado") Long idEstado
    ) {
        return ResponseEntity.ok(dadosSmsUseCase.executar(idsEspecialidades, idEstado));
    }

    @PostMapping("enderecos")
    public ResponseEntity<?> cadastraOuAtualizaEndereco(@RequestBody EnderecoRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaEnderecoUseCase.executar(request));
    }

    @GetMapping("enderecos/{profissionalId}")
    public ResponseEntity<EnderecoResponse> cadastraOuAtualizaEndereco(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaEnderecoUseCase.executar(profissionalId));
    }

    @PostMapping("contatos/telefones")
    public ResponseEntity<?> cadastraOuAtualizaTelefone(@RequestBody TelefoneRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaTelefoneUseCase.executar(request));
    }

    @GetMapping("contatos/telefones/{profissionalId}")
    public ResponseEntity<?> consultaTelefone(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaTelefoneUseCase.executar(profissionalId));
    }

    @PostMapping("contas")
    public ResponseEntity<?> cadastraOuAtualizaConta(@RequestBody ContaRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaContaUseCase.executar(request));
    }

    @GetMapping("contas/{profissionalId}")
    public ResponseEntity<?> consultaConta(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaContaUseCase.executar(profissionalId));
    }

    @PostMapping("complementos/profissional")
    public ResponseEntity<?> cadastraOuAtualizaComplemento(@RequestBody ComplementoRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaComplementoUseCase.executar(request));
    }

    @GetMapping("complementos/profissional/{profissionalId}")
    public ResponseEntity<?> consultaComplemento(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaComplementoUseCase.executar(profissionalId));
    }

    @PostMapping("experiencias")
    public ResponseEntity<CadastraAtualizaExperienciaResponse> cadastraOuAtualizaExperiencia(@RequestBody List<ExperienciaRequest> request) {
        return ResponseEntity.ok().body(cadastraAtualizaExperienciaUseCase.executar(request));
    }

    @GetMapping("experiencias/{profissionalId}")
    public List<ExperienciaResponse> consultaExperiencia(@PathVariable Long profissionalId) {
        return consultaExperienciaUseCase.executar(profissionalId);
    }

    @PostMapping("carreiras")
    public ResponseEntity<CadastraAtualizaCarreiraResponse> cadastraOuAtualizaCarreira(@RequestBody CarreiraRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaCarreiraUseCase.executar(request));
    }

    @GetMapping("carreiras/{profissionalId}")
    public ResponseEntity<?> consultaCarreira(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaCarreiraUseCase.executar(profissionalId));
    }

    @GetMapping("profissionais/atendimento")
    public ResponseEntity<List<ListaProfissionalResponse>> listaProfissional(@RequestHeader("profissionais") List<Long> profissionaisIds) {
        return ResponseEntity.ok().body(listaProfissionalUseCase.executar(profissionaisIds));
    }

    @PostMapping("escolaridade")
    public ResponseEntity<CadastraAtualizaEscolaridadeResponse> cadastraOuAtualizaEscolaridade(@RequestBody EscolaridadeRequest request) {
        return ResponseEntity.ok().body(cadastraAtualizaEscolaridadeUseCase.executar(request));
    }

    @GetMapping("escolaridade/{profissionalId}")
    public ResponseEntity<?> consultaEscolaridade(@PathVariable Long profissionalId) {
        return ResponseEntity.ok().body(consultaEscolaridadeUseCase.executar(profissionalId));
    }

    @GetMapping("profissionais/completo")
    public ResponseEntity<ProfissionalCompletoResponse> consultaProfissionalCompleto(@RequestHeader Long cpf) {
        return ResponseEntity.ok().body(consultaProfissionalCompletoUseCase.executar(cpf));
    }

    @GetMapping("profissionais/nome")
    public ResponseEntity<List<ProfissionalCpfResponse>> consultaProfissionalPorNome(@RequestHeader String nome) {
        return ResponseEntity.ok().body(consultaProfissionalPorNomeUseCase.executar(nome));
    }

}

