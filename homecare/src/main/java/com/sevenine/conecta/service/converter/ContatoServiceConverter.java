package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.ContatoRequest;
import com.sevenine.conecta.controllers.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controllers.data.response.ContatoResponse;
import com.sevenine.conecta.enumerator.TipoFlagEnum;
import com.sevenine.conecta.repository.data.Contato;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ContatoServiceConverter {

    public Contato toEntity(ContatoRequest request) {
        return Contato
                .builder()
                .idHomecare(request.getIdHomeCare())
                .telefoneFixo(request.getTelefoneFixo())
                .telefoneRecado(request.getTelefoneRecado())
                .telefoneCelular(request.getTelefoneCelular())
                .telefoneWhatsapp(request.getTelefoneWhatsapp())
                .email(request.getEmail())
                .flagAceiteDeclaracao(validaFlagAceiteDeclaracao(request))
                .flagAceitePrivacidade(validaFlagAceitePrivacidade(request))
                .build();
    }

    public ContatoResponse toResponse(Contato entity) {
        return ContatoResponse
                .builder()
                .id(entity.getId())
                .telefoneFixo(entity.getTelefoneFixo())
                .telefoneRecado(entity.getTelefoneRecado())
                .telefoneCelular(entity.getTelefoneCelular())
                .telefoneWhatsapp(entity.getTelefoneWhatsapp())
                .email(entity.getEmail())
                .flagAceiteDeclaracao(entity.getFlagAceiteDeclaracao().equals(TipoFlagEnum.SIM.name()))
                .flagAceitePrivacidade(entity.getFlagAceitePrivacidade().equals(TipoFlagEnum.SIM.name()))
                .idHomeCare(entity.getIdHomecare())
                .build();
    }

    public ContatoCadastroResponse toResponse(Long id) {
        return ContatoCadastroResponse.builder().id(id).build();
    }

    private String validaFlagAceiteDeclaracao(ContatoRequest request) {
        if (isNull(request.getFlagAceiteDeclaracao())) {
            return TipoFlagEnum.SIM.name();
        }
        return request.getFlagAceiteDeclaracao().equals("true") ? TipoFlagEnum.SIM.name() : TipoFlagEnum.NAO.name();
    }

    private String validaFlagAceitePrivacidade(ContatoRequest request) {
        if (isNull(request.getFlagAceitePrivacidade())) {
            return TipoFlagEnum.SIM.name();
        }
        return request.getFlagAceitePrivacidade().equals("true") ? TipoFlagEnum.SIM.name() : TipoFlagEnum.NAO.name();
    }

}
