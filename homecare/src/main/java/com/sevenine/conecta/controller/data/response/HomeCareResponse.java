package com.sevenine.conecta.controllers.data.response;

import com.sevenine.conecta.repository.data.HomeCare;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class HomeCareResponse {
    private final Long id;
    private final String nome;
    private final String cnpj;
    private final String site;
    private final String tipoDocumento;
    private final List<EspecialidadeResponse> especialidades;

    public HomeCareResponse(HomeCare homeCare) {
        super();
        this.id = homeCare.getId();
        this.nome = homeCare.getNome();
        this.cnpj = homeCare.getCnpj();
        this.site = homeCare.getSite();
        this.tipoDocumento = null;
        this.especialidades = null;
    }
    
    public static List<HomeCareResponse> ofEntities(List<HomeCare> homeCares) {
        List<HomeCareResponse> responses =
                homeCares.stream().map(HomeCareResponse::new).collect(Collectors.toList());
        return responses;
    }
    
}
