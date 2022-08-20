package com.sevenine.conecta.controller;

import com.sevenine.conecta.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.controller.data.response.HomeCareResponse;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import com.sevenine.conecta.usecase.ConsultaListaPlantonistaUseCase;
import com.sevenine.conecta.usecase.ConsultaPlantonistaUseCase;
import com.sevenine.conecta.usecase.HomeCareUseCase;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "homecares")
@RestController
public class HomeCareController {

    private final HomeCareUseCase homeCareUseCase;
    private final ConsultaPlantonistaUseCase consultaPlantonistaUseCase;
    private final ConsultaListaPlantonistaUseCase consultaListaPlantonistaUseCase;

    
    @GetMapping
    public ResponseEntity<?> homeCares() {
        List<HomeCareResponse> responses = homeCareUseCase.findAll();
        return ResponseEntity.ok().body(responses);
    }
    
    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody HomeCareRequest request) {
        HomeCareCadastroResponse response = homeCareUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> alteracao(@RequestBody HomeCareRequest request) {
        homeCareUseCase.alterar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consulta(@PathVariable Long id) {
        HomeCareResponse response = homeCareUseCase.consultar(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("plantonistas/{plantonistaId}")
    public ResponseEntity<PlantonistaResponse> plantonista(@RequestHeader Long homeCareId, @PathVariable Long plantonistaId) {
        PlantonistaResponse response = consultaPlantonistaUseCase.executar(plantonistaId, homeCareId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("plantonistas")
    public ResponseEntity<List<PlantonistaResponse>> plantonistas(@RequestHeader("plantonistas") List<Long> plantonistasIds) {
        List<PlantonistaResponse> responseList = consultaListaPlantonistaUseCase.executar(plantonistasIds);
        return ResponseEntity.ok().body(responseList);
    }

}
