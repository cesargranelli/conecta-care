package com.sevenine.conecta.controller;

import com.sevenine.conecta.usecase.DominioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "dominios")
@RestController
public class DominioController {

    private final DominioUseCase dominioUseCase;

    @GetMapping("genero")
    public ResponseEntity<?> generos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarGeneros());
    }

    @GetMapping("tipo-empresa")
    public ResponseEntity<?> tiposEmpresa() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTiposEmpresas());
    }

    @GetMapping("estado-civil")
    public ResponseEntity<?> estadosCivil() {
        return ResponseEntity.ok().body(dominioUseCase.consultarEstadosCivis());
    }

    @GetMapping("estado")
    public ResponseEntity<?> estados() {
        return ResponseEntity.ok().body(dominioUseCase.consultarEstados());
    }

    @GetMapping("conselho")
    public ResponseEntity<?> conselhos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarConselhos());
    }

    @GetMapping("area-atendimento")
    public ResponseEntity<?> areasAtendimento() {
        return ResponseEntity.ok().body(dominioUseCase.consultarAreasAtendimentos());
    }

    @GetMapping("transporte")
    public ResponseEntity<?> transportes() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTransportes());
    }

    @GetMapping("instrucao")
    public ResponseEntity<?> instrucoes() {
        return ResponseEntity.ok().body(dominioUseCase.consultarInstrucoes());
    }

    @GetMapping("categoria-cnh")
    public ResponseEntity<?> categoriasCnh() {
        return ResponseEntity.ok().body(dominioUseCase.consultarCategoriasCnh());
    }

    @GetMapping("tipo-conta")
    public ResponseEntity<?> tiposConta() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTiposContas());
    }

    @GetMapping("banco")
    public ResponseEntity<?> bancos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarBancos());
    }

    @GetMapping("pais")
    public ResponseEntity<?> paises() {
        return ResponseEntity.ok().body(dominioUseCase.consultarPaises());
    }

    @GetMapping("parentesco")
    public ResponseEntity<?> parentescos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarParentescos());
    }

    @GetMapping("modelo")
    public ResponseEntity<?> modelos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarModelos());
    }

    @GetMapping("grupo")
    public ResponseEntity<?> grupos() {
        return ResponseEntity.ok().body(dominioUseCase.consultarGrupos());
    }

    @GetMapping("status-atendimento")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok().body(dominioUseCase.consultarStatusAtendimentos());
    }

}

