package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.repository.ProfissionalRepository;
import com.sevenine.conecta.services.ProfissionalFiltroEspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfissionalFiltroEspecialidadeServiceImpl implements ProfissionalFiltroEspecialidadeService {

//    private final ProfissionalFiltroEspecialidadeMapper mapper;

    private final ProfissionalRepository repository;

    @Override
    public List<ProfissionalResponse> consultar(List<Long> idsEspecialidades) {
//        Optional<List<Profissional>> optional = repository.findByCarreiraEspecialidadesIdIn(idsEspecialidades);
//
//        List<Profissional> profissionais = optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
//                "Nenhum profissional encontrado", HttpStatus.NOT_FOUND)).stream().distinct().collect(Collectors.toList());

        return null; //mapper.fromListEntityData(profissionais);
    }

}
