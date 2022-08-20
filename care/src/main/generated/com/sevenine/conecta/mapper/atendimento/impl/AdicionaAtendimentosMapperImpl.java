package com.sevenine.conecta.mapper.atendimento.impl;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.EnderecoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.EstadoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.GrupoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.PaisRequest;
import com.sevenine.conecta.controller.data.request.atendimento.TipoAtendimentoRequest;
import com.sevenine.conecta.mapper.atendimento.AdicionaAtendimentosMapper;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.repository.data.Especialidade;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Grupo;
import com.sevenine.conecta.repository.data.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T14:36:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class AdicionaAtendimentosMapperImpl implements AdicionaAtendimentosMapper {

    @Override
    public Atendimento toEntityData(AdicionaAtendimentoRequest request) {
        if ( request == null ) {
            return null;
        }

        Atendimento atendimento = new Atendimento();

        atendimento.setData( request.getData() );
        atendimento.setHora( request.getHora() );
        atendimento.setObservacao( request.getObservacao() );
        atendimento.setEndereco( enderecoRequestToEndereco( request.getEndereco() ) );
        atendimento.setTratamentoId( request.getTratamentoId() );
        atendimento.setPlantonistaId( request.getPlantonistaId() );
        atendimento.setProfissionalId( request.getProfissionalId() );
        atendimento.setValorHomeCare( request.getValorHomeCare() );
        atendimento.setValorProfissional( request.getValorProfissional() );
        atendimento.setValorPaciente( request.getValorPaciente() );
        atendimento.setValorAjudaCusto( request.getValorAjudaCusto() );
        atendimento.setHomeCareId( request.getHomeCareId() );
        atendimento.setPacienteId( request.getPacienteId() );
        atendimento.setGrupos( grupoRequestListToGrupoList( request.getGrupos() ) );
        atendimento.setTipoAtendimento( tipoAtendimentoRequestToEspecialidade( request.getTipoAtendimento() ) );

        atendimento.setCodigoSeguranca( atendimento.geraCodigoSeguranca() );

        return atendimento;
    }

    @Override
    public List<Atendimento> toEntityDataList(List<AdicionaAtendimentoRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Atendimento> list = new ArrayList<Atendimento>( requests.size() );
        for ( AdicionaAtendimentoRequest adicionaAtendimentoRequest : requests ) {
            list.add( toEntityData( adicionaAtendimentoRequest ) );
        }

        return list;
    }

    protected Estado estadoRequestToEstado(EstadoRequest estadoRequest) {
        if ( estadoRequest == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setId( estadoRequest.getId() );
        estado.setCodigo( estadoRequest.getCodigo() );
        estado.setUf( estadoRequest.getUf() );
        estado.setNome( estadoRequest.getNome() );
        estado.setRegiao( estadoRequest.getRegiao() );

        return estado;
    }

    protected Pais paisRequestToPais(PaisRequest paisRequest) {
        if ( paisRequest == null ) {
            return null;
        }

        Pais pais = new Pais();

        pais.setId( paisRequest.getId() );
        pais.setCodigo( paisRequest.getCodigo() );
        pais.setNome( paisRequest.getNome() );

        return pais;
    }

    protected Endereco enderecoRequestToEndereco(EnderecoRequest enderecoRequest) {
        if ( enderecoRequest == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( enderecoRequest.getId() );
        endereco.setLogradouro( enderecoRequest.getLogradouro() );
        endereco.setNumero( enderecoRequest.getNumero() );
        endereco.setComplemento( enderecoRequest.getComplemento() );
        endereco.setBairro( enderecoRequest.getBairro() );
        endereco.setCidade( enderecoRequest.getCidade() );
        endereco.setCep( enderecoRequest.getCep() );
        endereco.setEstado( estadoRequestToEstado( enderecoRequest.getEstado() ) );
        endereco.setPais( paisRequestToPais( enderecoRequest.getPais() ) );

        return endereco;
    }

    protected Grupo grupoRequestToGrupo(GrupoRequest grupoRequest) {
        if ( grupoRequest == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setId( grupoRequest.getId() );
        grupo.setDescricao( grupoRequest.getDescricao() );

        return grupo;
    }

    protected List<Grupo> grupoRequestListToGrupoList(List<GrupoRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Grupo> list1 = new ArrayList<Grupo>( list.size() );
        for ( GrupoRequest grupoRequest : list ) {
            list1.add( grupoRequestToGrupo( grupoRequest ) );
        }

        return list1;
    }

    protected Especialidade tipoAtendimentoRequestToEspecialidade(TipoAtendimentoRequest tipoAtendimentoRequest) {
        if ( tipoAtendimentoRequest == null ) {
            return null;
        }

        Especialidade especialidade = new Especialidade();

        especialidade.setId( tipoAtendimentoRequest.getId() );
        especialidade.setNome( tipoAtendimentoRequest.getNome() );

        return especialidade;
    }
}
