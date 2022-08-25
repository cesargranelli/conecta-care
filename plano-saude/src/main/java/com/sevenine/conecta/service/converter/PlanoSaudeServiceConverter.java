package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controllers.data.response.EspecialidadeResponse;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controllers.data.response.PlanoSaudeResponse;
import com.sevenine.conecta.enumerator.TipoEmpresaEnum;
import com.sevenine.conecta.repository.data.Especialidade;
import com.sevenine.conecta.repository.data.PlanoSaude;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanoSaudeServiceConverter {

    public PlanoSaude toEntity(PlanoSaudeRequest request) {
        return PlanoSaude.builder()
                .id(request.getId())
                .nome(request.getNome())
                .cnpj(request.getCnpj())
                .anoFundacao(request.getAnoFundacao())
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
                .planoSaudeMatriz(request.getPlanoSaudeMatriz())
                .build();
    }

    public PlanoSaudeResponse toResponse(PlanoSaude entity) {
        return PlanoSaudeResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cnpj(entity.getCnpj())
                .anoFundacao(entity.getAnoFundacao())
                .tipoDocumento(entity.getTipoEmpresa().getDescricao())
                .especialidades(entity.getEspecialidades().stream()
                        .map(especialidade -> EspecialidadeResponse.builder()
                                .id(especialidade.getId())
                                .nome(especialidade.getNome())
                                .build()).collect(Collectors.toList()
                        )
                )
                .planoSaudeMatriz(entity.getPlanoSaudeMatriz())
                .build();
    }

    public PlanoSaudeCadastroResponse toResponse(Long id) {
        return PlanoSaudeCadastroResponse.builder().id(id).build();
    }

    public List<PlanoSaudeResponse> toResponseList(List<PlanoSaude> entityList) {
        return entityList.stream().map(this::toList).collect(Collectors.toList());
    }

    private PlanoSaudeResponse toList(PlanoSaude entity) {
        return PlanoSaudeResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cnpj(entity.getCnpj())
                .anoFundacao(entity.getAnoFundacao())
                .tipoDocumento(entity.getTipoEmpresa().getDescricao())
                .especialidades(entity.getEspecialidades().stream()
                        .map(especialidade -> EspecialidadeResponse.builder()
                                .id(especialidade.getId())
                                .nome(especialidade.getNome())
                                .build()).collect(Collectors.toList()
                        )
                )
                .planoSaudeMatriz(entity.getPlanoSaudeMatriz())
                .build();
    }

}
