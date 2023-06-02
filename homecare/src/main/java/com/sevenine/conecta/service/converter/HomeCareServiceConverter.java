package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.adapter.controller.data.request.HomeCareRequest;
import com.sevenine.conecta.adapter.controller.data.response.EspecialidadeResponse;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.HomeCareResponse;
import com.sevenine.conecta.enumerator.TipoEmpresaEnum;
import com.sevenine.conecta.exception.HomeCareNaoEncontradaException;
import com.sevenine.conecta.repository.data.Especialidade;
import com.sevenine.conecta.repository.data.HomeCare;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class HomeCareServiceConverter {

    public HomeCare toEntity(HomeCareRequest request) {
        return HomeCare.builder()
                .id(request.getId())
                .nome(request.getNome())
                .cnpj(request.getCnpj())
                .site(request.getSite())
                .tipoEmpresa(TipoEmpresa.builder()
                        .id((long) TipoEmpresaEnum.valueOf(request.getTipoDocumento()).ordinal())
                        .descricao(TipoEmpresaEnum.valueOf(request.getTipoDocumento()).name())
                        .build()
                )
                .especialidades(request.getEspecialidades().stream()
                        .map(especialidadeRequest -> Especialidade.builder()
                                .id(especialidadeRequest.getId())
                                .nome(especialidadeRequest.getNome())
                                .build()).collect(Collectors.toList()
                        )
                )
                .build();
    }

    public HomeCareResponse toResponse(HomeCare entity) {
        if (isNull(entity.getCnpj())) throw new HomeCareNaoEncontradaException(null, null);

        return HomeCareResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cnpj(entity.getCnpj())
                .site(entity.getSite())
                .tipoDocumento(entity.getTipoEmpresa().getDescricao())
                .especialidades(entity.getEspecialidades().stream()
                        .map(especialidade -> EspecialidadeResponse.builder()
                                .id(especialidade.getId())
                                .nome(especialidade.getNome())
                                .build()).collect(Collectors.toList()
                        )
                )
                .build();
    }

    public HomeCareCadastroResponse toResponse(Long id) {
        return HomeCareCadastroResponse.builder().id(id).build();
    }

}
