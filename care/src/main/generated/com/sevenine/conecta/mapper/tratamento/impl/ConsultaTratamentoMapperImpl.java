package com.sevenine.conecta.mapper.tratamento.impl;

import com.sevenine.conecta.controller.data.response.atendimento.TipoAtendimentoResponse;
import com.sevenine.conecta.mapper.tratamento.ConsultaTratamentoMapper;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import com.sevenine.conecta.repository.data.Campo;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.repository.data.Especialidade;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Grupo;
import com.sevenine.conecta.repository.data.Modelo;
import com.sevenine.conecta.repository.data.Pais;
import com.sevenine.conecta.repository.data.Procedimento;
import com.sevenine.conecta.repository.data.StatusAtendimento;
import com.sevenine.conecta.repository.data.StatusTratamento;
import com.sevenine.conecta.repository.data.Subgrupo;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.repository.data.TratamentoSituacao;
import com.sevenine.conecta.service.data.response.AcompanhanteResponse;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.service.data.response.AtendimentoSituacaoResponse;
import com.sevenine.conecta.service.data.response.CampoResponse;
import com.sevenine.conecta.service.data.response.EnderecoResponse;
import com.sevenine.conecta.service.data.response.EstadoResponse;
import com.sevenine.conecta.service.data.response.GrupoResponse;
import com.sevenine.conecta.service.data.response.HomeCareResponse;
import com.sevenine.conecta.service.data.response.ModeloResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import com.sevenine.conecta.service.data.response.PaisResponse;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import com.sevenine.conecta.service.data.response.ProcedimentoResponse;
import com.sevenine.conecta.service.data.response.StatusAtendimentoResponse;
import com.sevenine.conecta.service.data.response.StatusTratamentoResponse;
import com.sevenine.conecta.service.data.response.SubgrupoResponse;
import com.sevenine.conecta.service.data.response.TratamentoResponse;
import com.sevenine.conecta.service.data.response.TratamentoSituacaoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T14:36:58-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaTratamentoMapperImpl implements ConsultaTratamentoMapper {

    @Override
    public AtendimentoDetalheResponse fromAtendimentoData(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        AtendimentoDetalheResponse atendimentoDetalheResponse = new AtendimentoDetalheResponse();

        atendimentoDetalheResponse.setProfissional( atendimentoToAtendimentoProfissionalResponse( atendimento ) );
        atendimentoDetalheResponse.setPlantonista( atendimentoToPlantonistaResponse( atendimento ) );
        atendimentoDetalheResponse.setId( atendimento.getId() );
        atendimentoDetalheResponse.setData( atendimento.getData() );
        atendimentoDetalheResponse.setHora( atendimento.getHora() );
        atendimentoDetalheResponse.setObservacao( atendimento.getObservacao() );
        atendimentoDetalheResponse.setEndereco( enderecoToEnderecoResponse( atendimento.getEndereco() ) );
        atendimentoDetalheResponse.setValorHomeCare( atendimento.getValorHomeCare() );
        atendimentoDetalheResponse.setValorProfissional( atendimento.getValorProfissional() );
        atendimentoDetalheResponse.setValorPaciente( atendimento.getValorPaciente() );
        atendimentoDetalheResponse.setValorAjudaCusto( atendimento.getValorAjudaCusto() );
        atendimentoDetalheResponse.setGrupos( grupoListToGrupoResponseList( atendimento.getGrupos() ) );
        atendimentoDetalheResponse.setSituacoes( atendimentoSituacaoListToAtendimentoSituacaoResponseList( atendimento.getSituacoes() ) );
        atendimentoDetalheResponse.setProcedimento( procedimentoToProcedimentoResponse( atendimento.getProcedimento() ) );
        atendimentoDetalheResponse.setTipoAtendimento( especialidadeToTipoAtendimentoResponse( atendimento.getTipoAtendimento() ) );

        return atendimentoDetalheResponse;
    }

    @Override
    public TratamentoResponse fromEntityData(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        TratamentoResponse tratamentoResponse = new TratamentoResponse();

        tratamentoResponse.setPaciente( tratamentoToPacienteResponse( tratamento ) );
        tratamentoResponse.setAcompanhante( tratamentoToAcompanhanteResponse( tratamento ) );
        tratamentoResponse.setProfissional( tratamentoToAtendimentoProfissionalResponse( tratamento ) );
        tratamentoResponse.setHomeCare( tratamentoToHomeCareResponse( tratamento ) );
        tratamentoResponse.setAtendimentos( atendimentoListToAtendimentoDetalheResponseList( tratamento.getAtendimentos() ) );
        tratamentoResponse.setId( tratamento.getId() );
        tratamentoResponse.setDescricao( tratamento.getDescricao() );
        tratamentoResponse.setValorKilometragem( tratamento.getValorKilometragem() );
        tratamentoResponse.setSituacoes( tratamentoSituacaoListToTratamentoSituacaoResponseList( tratamento.getSituacoes() ) );

        return tratamentoResponse;
    }

    protected AtendimentoProfissionalResponse atendimentoToAtendimentoProfissionalResponse(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        AtendimentoProfissionalResponse atendimentoProfissionalResponse = new AtendimentoProfissionalResponse();

        atendimentoProfissionalResponse.setId( atendimento.getProfissionalId() );

        return atendimentoProfissionalResponse;
    }

    protected PlantonistaResponse atendimentoToPlantonistaResponse(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        PlantonistaResponse plantonistaResponse = new PlantonistaResponse();

        plantonistaResponse.setId( atendimento.getPlantonistaId() );

        return plantonistaResponse;
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

    protected ProcedimentoResponse procedimentoToProcedimentoResponse(Procedimento procedimento) {
        if ( procedimento == null ) {
            return null;
        }

        ProcedimentoResponse procedimentoResponse = new ProcedimentoResponse();

        procedimentoResponse.setId( procedimento.getId() );
        procedimentoResponse.setDescricao( procedimento.getDescricao() );

        return procedimentoResponse;
    }

    protected TipoAtendimentoResponse especialidadeToTipoAtendimentoResponse(Especialidade especialidade) {
        if ( especialidade == null ) {
            return null;
        }

        TipoAtendimentoResponse tipoAtendimentoResponse = new TipoAtendimentoResponse();

        tipoAtendimentoResponse.setId( especialidade.getId() );
        tipoAtendimentoResponse.setNome( especialidade.getNome() );

        return tipoAtendimentoResponse;
    }

    protected PacienteResponse tratamentoToPacienteResponse(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        PacienteResponse pacienteResponse = new PacienteResponse();

        pacienteResponse.setId( tratamento.getPacienteId() );

        return pacienteResponse;
    }

    protected AcompanhanteResponse tratamentoToAcompanhanteResponse(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        AcompanhanteResponse acompanhanteResponse = new AcompanhanteResponse();

        acompanhanteResponse.setId( tratamento.getAcompanhanteId() );

        return acompanhanteResponse;
    }

    protected AtendimentoProfissionalResponse tratamentoToAtendimentoProfissionalResponse(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        AtendimentoProfissionalResponse atendimentoProfissionalResponse = new AtendimentoProfissionalResponse();

        atendimentoProfissionalResponse.setId( tratamento.getProfissionalId() );

        return atendimentoProfissionalResponse;
    }

    protected HomeCareResponse tratamentoToHomeCareResponse(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        HomeCareResponse homeCareResponse = new HomeCareResponse();

        homeCareResponse.setId( tratamento.getHomeCareId() );

        return homeCareResponse;
    }

    protected List<AtendimentoDetalheResponse> atendimentoListToAtendimentoDetalheResponseList(List<Atendimento> list) {
        if ( list == null ) {
            return null;
        }

        List<AtendimentoDetalheResponse> list1 = new ArrayList<AtendimentoDetalheResponse>( list.size() );
        for ( Atendimento atendimento : list ) {
            list1.add( fromAtendimentoData( atendimento ) );
        }

        return list1;
    }

    protected StatusTratamentoResponse statusTratamentoToStatusTratamentoResponse(StatusTratamento statusTratamento) {
        if ( statusTratamento == null ) {
            return null;
        }

        StatusTratamentoResponse statusTratamentoResponse = new StatusTratamentoResponse();

        statusTratamentoResponse.setId( statusTratamento.getId() );
        statusTratamentoResponse.setDescricao( statusTratamento.getDescricao() );

        return statusTratamentoResponse;
    }

    protected TratamentoSituacaoResponse tratamentoSituacaoToTratamentoSituacaoResponse(TratamentoSituacao tratamentoSituacao) {
        if ( tratamentoSituacao == null ) {
            return null;
        }

        TratamentoSituacaoResponse tratamentoSituacaoResponse = new TratamentoSituacaoResponse();

        tratamentoSituacaoResponse.setId( tratamentoSituacao.getId() );
        tratamentoSituacaoResponse.setStatus( statusTratamentoToStatusTratamentoResponse( tratamentoSituacao.getStatus() ) );
        tratamentoSituacaoResponse.setDataHora( tratamentoSituacao.getDataHora() );

        return tratamentoSituacaoResponse;
    }

    protected List<TratamentoSituacaoResponse> tratamentoSituacaoListToTratamentoSituacaoResponseList(List<TratamentoSituacao> list) {
        if ( list == null ) {
            return null;
        }

        List<TratamentoSituacaoResponse> list1 = new ArrayList<TratamentoSituacaoResponse>( list.size() );
        for ( TratamentoSituacao tratamentoSituacao : list ) {
            list1.add( tratamentoSituacaoToTratamentoSituacaoResponse( tratamentoSituacao ) );
        }

        return list1;
    }
}
