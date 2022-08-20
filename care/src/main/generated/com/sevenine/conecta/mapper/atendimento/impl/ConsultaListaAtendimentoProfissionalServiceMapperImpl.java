package com.sevenine.conecta.mapper.atendimento.impl;

import com.sevenine.conecta.mapper.atendimento.ConsultaListaAtendimentoProfissionalServiceMapper;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoCampoBaixa;
import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import com.sevenine.conecta.repository.data.Campo;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Grupo;
import com.sevenine.conecta.repository.data.Modelo;
import com.sevenine.conecta.repository.data.Pais;
import com.sevenine.conecta.repository.data.Procedimento;
import com.sevenine.conecta.repository.data.StatusAtendimento;
import com.sevenine.conecta.repository.data.Subgrupo;
import com.sevenine.conecta.service.data.response.AtendimentoResponse;
import com.sevenine.conecta.service.data.response.AtendimentoSituacaoResponse;
import com.sevenine.conecta.service.data.response.CampoResponse;
import com.sevenine.conecta.service.data.response.EnderecoResponse;
import com.sevenine.conecta.service.data.response.EstadoResponse;
import com.sevenine.conecta.service.data.response.GrupoResponse;
import com.sevenine.conecta.service.data.response.ModeloResponse;
import com.sevenine.conecta.service.data.response.PaisResponse;
import com.sevenine.conecta.service.data.response.ProcedimentoResponse;
import com.sevenine.conecta.service.data.response.StatusAtendimentoResponse;
import com.sevenine.conecta.service.data.response.SubgrupoResponse;
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
public class ConsultaListaAtendimentoProfissionalServiceMapperImpl implements ConsultaListaAtendimentoProfissionalServiceMapper {

    @Override
    public AtendimentoResponse fromEntityData(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        AtendimentoResponse atendimentoResponse = new AtendimentoResponse();

        atendimentoResponse.setId( atendimento.getId() );
        atendimentoResponse.setData( atendimento.getData() );
        atendimentoResponse.setHora( atendimento.getHora() );
        atendimentoResponse.setObservacao( atendimento.getObservacao() );
        atendimentoResponse.setEndereco( enderecoToEnderecoResponse( atendimento.getEndereco() ) );
        atendimentoResponse.setTratamentoId( atendimento.getTratamentoId() );
        atendimentoResponse.setPlantonistaId( atendimento.getPlantonistaId() );
        atendimentoResponse.setProfissionalId( atendimento.getProfissionalId() );
        atendimentoResponse.setProcedimento( procedimentoToProcedimentoResponse( atendimento.getProcedimento() ) );
        atendimentoResponse.setValorHomeCare( atendimento.getValorHomeCare() );
        atendimentoResponse.setValorProfissional( atendimento.getValorProfissional() );
        atendimentoResponse.setValorPaciente( atendimento.getValorPaciente() );
        atendimentoResponse.setValorAjudaCusto( atendimento.getValorAjudaCusto() );
        atendimentoResponse.setHomeCareId( atendimento.getHomeCareId() );
        atendimentoResponse.setPacienteId( atendimento.getPacienteId() );
        atendimentoResponse.setCampos( atendimentoCampoBaixaListToCampoResponseList( atendimento.getCampos() ) );
        atendimentoResponse.setGrupos( grupoListToGrupoResponseList( atendimento.getGrupos() ) );
        atendimentoResponse.setSituacoes( atendimentoSituacaoListToAtendimentoSituacaoResponseList( atendimento.getSituacoes() ) );
        atendimentoResponse.setCodigoSeguranca( atendimento.getCodigoSeguranca() );
        atendimentoResponse.setAssinatura( atendimento.getAssinatura() );

        return atendimentoResponse;
    }

    protected EstadoResponse estadoToEstadoResponse(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        EstadoResponse estadoResponse = new EstadoResponse();

        estadoResponse.setId( estado.getId() );
        estadoResponse.setCodigo( estado.getCodigo() );
        estadoResponse.setUf( estado.getUf() );
        estadoResponse.setNome( estado.getNome() );
        estadoResponse.setRegiao( estado.getRegiao() );

        return estadoResponse;
    }

    protected PaisResponse paisToPaisResponse(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        PaisResponse paisResponse = new PaisResponse();

        paisResponse.setId( pais.getId() );
        paisResponse.setCodigo( pais.getCodigo() );
        paisResponse.setNome( pais.getNome() );

        return paisResponse;
    }

    protected EnderecoResponse enderecoToEnderecoResponse(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoResponse enderecoResponse = new EnderecoResponse();

        enderecoResponse.setId( endereco.getId() );
        enderecoResponse.setLogradouro( endereco.getLogradouro() );
        enderecoResponse.setNumero( endereco.getNumero() );
        enderecoResponse.setComplemento( endereco.getComplemento() );
        enderecoResponse.setBairro( endereco.getBairro() );
        enderecoResponse.setCidade( endereco.getCidade() );
        enderecoResponse.setCep( endereco.getCep() );
        enderecoResponse.setEstado( estadoToEstadoResponse( endereco.getEstado() ) );
        enderecoResponse.setPais( paisToPaisResponse( endereco.getPais() ) );

        return enderecoResponse;
    }

    protected ProcedimentoResponse procedimentoToProcedimentoResponse(Procedimento procedimento) {
        if ( procedimento == null ) {
            return null;
        }

        ProcedimentoResponse procedimentoResponse = new ProcedimentoResponse();

        procedimentoResponse.setId( procedimento.getId() );
        procedimentoResponse.setDescricao( procedimento.getDescricao() );

        return procedimentoResponse;
    }

    protected CampoResponse atendimentoCampoBaixaToCampoResponse(AtendimentoCampoBaixa atendimentoCampoBaixa) {
        if ( atendimentoCampoBaixa == null ) {
            return null;
        }

        CampoResponse campoResponse = new CampoResponse();

        campoResponse.setId( atendimentoCampoBaixa.getId() );

        return campoResponse;
    }

    protected List<CampoResponse> atendimentoCampoBaixaListToCampoResponseList(List<AtendimentoCampoBaixa> list) {
        if ( list == null ) {
            return null;
        }

        List<CampoResponse> list1 = new ArrayList<CampoResponse>( list.size() );
        for ( AtendimentoCampoBaixa atendimentoCampoBaixa : list ) {
            list1.add( atendimentoCampoBaixaToCampoResponse( atendimentoCampoBaixa ) );
        }

        return list1;
    }

    protected CampoResponse campoToCampoResponse(Campo campo) {
        if ( campo == null ) {
            return null;
        }

        CampoResponse campoResponse = new CampoResponse();

        campoResponse.setId( campo.getId() );
        campoResponse.setTipo( campo.getTipo() );
        campoResponse.setTamanho( campo.getTamanho() );
        campoResponse.setPre( campo.getPre() );
        campoResponse.setPos( campo.getPos() );

        return campoResponse;
    }

    protected List<CampoResponse> campoListToCampoResponseList(List<Campo> list) {
        if ( list == null ) {
            return null;
        }

        List<CampoResponse> list1 = new ArrayList<CampoResponse>( list.size() );
        for ( Campo campo : list ) {
            list1.add( campoToCampoResponse( campo ) );
        }

        return list1;
    }

    protected SubgrupoResponse subgrupoToSubgrupoResponse(Subgrupo subgrupo) {
        if ( subgrupo == null ) {
            return null;
        }

        SubgrupoResponse subgrupoResponse = new SubgrupoResponse();

        subgrupoResponse.setId( subgrupo.getId() );
        subgrupoResponse.setDescricao( subgrupo.getDescricao() );
        subgrupoResponse.setCampos( campoListToCampoResponseList( subgrupo.getCampos() ) );

        return subgrupoResponse;
    }

    protected List<SubgrupoResponse> subgrupoListToSubgrupoResponseList(List<Subgrupo> list) {
        if ( list == null ) {
            return null;
        }

        List<SubgrupoResponse> list1 = new ArrayList<SubgrupoResponse>( list.size() );
        for ( Subgrupo subgrupo : list ) {
            list1.add( subgrupoToSubgrupoResponse( subgrupo ) );
        }

        return list1;
    }

    protected ModeloResponse modeloToModeloResponse(Modelo modelo) {
        if ( modelo == null ) {
            return null;
        }

        ModeloResponse modeloResponse = new ModeloResponse();

        modeloResponse.setId( modelo.getId() );
        modeloResponse.setDescricao( modelo.getDescricao() );

        return modeloResponse;
    }

    protected GrupoResponse grupoToGrupoResponse(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        GrupoResponse grupoResponse = new GrupoResponse();

        grupoResponse.setId( grupo.getId() );
        grupoResponse.setDescricao( grupo.getDescricao() );
        grupoResponse.setSubgrupos( subgrupoListToSubgrupoResponseList( grupo.getSubgrupos() ) );
        grupoResponse.setModelo( modeloToModeloResponse( grupo.getModelo() ) );

        return grupoResponse;
    }

    protected List<GrupoResponse> grupoListToGrupoResponseList(List<Grupo> list) {
        if ( list == null ) {
            return null;
        }

        List<GrupoResponse> list1 = new ArrayList<GrupoResponse>( list.size() );
        for ( Grupo grupo : list ) {
            list1.add( grupoToGrupoResponse( grupo ) );
        }

        return list1;
    }

    protected StatusAtendimentoResponse statusAtendimentoToStatusAtendimentoResponse(StatusAtendimento statusAtendimento) {
        if ( statusAtendimento == null ) {
            return null;
        }

        StatusAtendimentoResponse statusAtendimentoResponse = new StatusAtendimentoResponse();

        statusAtendimentoResponse.setId( statusAtendimento.getId() );
        statusAtendimentoResponse.setDescricao( statusAtendimento.getDescricao() );

        return statusAtendimentoResponse;
    }

    protected AtendimentoSituacaoResponse atendimentoSituacaoToAtendimentoSituacaoResponse(AtendimentoSituacao atendimentoSituacao) {
        if ( atendimentoSituacao == null ) {
            return null;
        }

        AtendimentoSituacaoResponse atendimentoSituacaoResponse = new AtendimentoSituacaoResponse();

        atendimentoSituacaoResponse.setId( atendimentoSituacao.getId() );
        atendimentoSituacaoResponse.setStatus( statusAtendimentoToStatusAtendimentoResponse( atendimentoSituacao.getStatus() ) );
        atendimentoSituacaoResponse.setDataHora( atendimentoSituacao.getDataHora() );

        return atendimentoSituacaoResponse;
    }

    protected List<AtendimentoSituacaoResponse> atendimentoSituacaoListToAtendimentoSituacaoResponseList(List<AtendimentoSituacao> list) {
        if ( list == null ) {
            return null;
        }

        List<AtendimentoSituacaoResponse> list1 = new ArrayList<AtendimentoSituacaoResponse>( list.size() );
        for ( AtendimentoSituacao atendimentoSituacao : list ) {
            list1.add( atendimentoSituacaoToAtendimentoSituacaoResponse( atendimentoSituacao ) );
        }

        return list1;
    }
}
