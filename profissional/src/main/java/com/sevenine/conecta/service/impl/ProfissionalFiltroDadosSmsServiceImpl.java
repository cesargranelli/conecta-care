package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalFiltroDadosSmsResponse;
import com.sevenine.conecta.repository.ProfissionalRepository;
import com.sevenine.conecta.services.ProfissionalFiltroDadosSmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfissionalFiltroDadosSmsServiceImpl implements ProfissionalFiltroDadosSmsService {

//    private final ProfissionalFiltroDadosSmsMapper mapper;

    private final ProfissionalRepository repository;

    @Override
    public List<ProfissionalFiltroDadosSmsResponse> consultar(List<Long> idsEspecialidades, Long idEstado) {
//        Optional<List<Profissional>> optional =
//                repository.findByCarreiraEspecialidadesIdInAndEnderecoEstadoId(idsEspecialidades, idEstado);
//
//        List<Profissional> profissionais = optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
//                "Nenhum profissional encontrado", HttpStatus.NOT_FOUND)).stream().distinct().collect(Collectors.toList());

        return null; //mapper.fromListEntityData(profissionais);
    }

}
