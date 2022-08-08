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
        return ResponseEntity.ok().body("dominios");//ResponseEntity.ok().body(dominioUseCase.consultarGeneros());
    }

    @GetMapping("tipo-empresa")
    public ResponseEntity<?> tipoEmpresa() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTiposEmpresas());
    }

    @GetMapping("estado-civil")
    public ResponseEntity<?> estadoCivil() {
        return ResponseEntity.ok().body(dominioUseCase.consultarEstadosCivis());
    }

    @GetMapping("estado")
    public ResponseEntity<?> estado() {
        return ResponseEntity.ok().body(dominioUseCase.consultarEstados());
    }

    @GetMapping("conselho")
    public ResponseEntity<?> conselho() {
        return ResponseEntity.ok().body(dominioUseCase.consultarConselhos());
    }

    @GetMapping("area-atendimento")
    public ResponseEntity<?> areaAtendimento() {
        return ResponseEntity.ok().body(dominioUseCase.consultarAreasAtendimentos());
    }

    @GetMapping("transporte")
    public ResponseEntity<?> transporte() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTransportes());
    }

    @GetMapping("instrucao")
    public ResponseEntity<?> instrucao() {
        return ResponseEntity.ok().body(dominioUseCase.consultarInstrucoes());
    }

    @GetMapping("categoria-cnh")
    public ResponseEntity<?> categoriaCnh() {
        return ResponseEntity.ok().body(dominioUseCase.consultarCategoriasCnh());
    }

    @GetMapping("tipo-conta")
    public ResponseEntity<?> tipoConta() {
        return ResponseEntity.ok().body(dominioUseCase.consultarTiposContas());
    }

    @GetMapping("banco")
    public ResponseEntity<?> banco() {
        return ResponseEntity.ok().body(dominioUseCase.consultarBancos());
    }

    @GetMapping("pais")
    public ResponseEntity<?> pais() {
        return ResponseEntity.ok().body(dominioUseCase.consultarPaises());
    }

    @GetMapping("parentesco")
    public ResponseEntity<?> parentesco() {
        return ResponseEntity.ok().body(dominioUseCase.consultarParentescos());
    }

    @GetMapping("modelo")
    public ResponseEntity<?> modelo() {
        return ResponseEntity.ok().body(dominioUseCase.consultarModelos());
    }

    @GetMapping("grupo")
    public ResponseEntity<?> grupo() {
        return ResponseEntity.ok().body(dominioUseCase.consultarGrupos());
    }

    @GetMapping("status-atendimento")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok().body(dominioUseCase.consultarStatusAtendimentos());
    }
    
}

