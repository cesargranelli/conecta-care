package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.AreaAtendimentoRequest;
import com.sevenine.conecta.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.controller.data.request.ConselhoRequest;
import com.sevenine.conecta.controller.data.request.TransporteRequest;
import com.sevenine.conecta.controller.data.request.UfConselhoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaCarreiraResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaCarreiraMapper;
import com.sevenine.conecta.repository.data.AreaAtendimento;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.repository.data.Conselho;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.Transporte;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaCarreiraMapperImpl implements CadastraAtualizaCarreiraMapper {

    @Override
    public Carreira toEntityData(CarreiraRequest request) {
        if ( request == null ) {
            return null;
        }

        Carreira carreira = new Carreira();

        carreira.setTransporte( transporteRequestToTransporte( request.getTransporte() ) );
        carreira.setEstado( ufConselhoRequestToEstado( request.getUfConselho() ) );
        carreira.setConselho( conselhoRequestToConselho( request.getConselho() ) );
        carreira.setProfissional( carreiraRequestToProfissional( request ) );
        carreira.setId( request.getId() );
        carreira.setRegistroProfissional( request.getRegistroProfissional() );
        carreira.setNomeReferencia1( request.getNomeReferencia1() );
        carreira.setNomeReferencia2( request.getNomeReferencia2() );
        carreira.setTelefoneReferencia1( request.getTelefoneReferencia1() );
        carreira.setTelefoneReferencia2( request.getTelefoneReferencia2() );
        carreira.setAreasAtendimento( areaAtendimentoRequestListToAreaAtendimentoList( request.getAreasAtendimento() ) );

        return carreira;
    }

    @Override
    public CadastraAtualizaCarreiraResponse fromEntityData(Carreira carreira) {
        if ( carreira == null ) {
            return null;
        }

        CadastraAtualizaCarreiraResponse cadastraAtualizaCarreiraResponse = new CadastraAtualizaCarreiraResponse();

        cadastraAtualizaCarreiraResponse.setProfissionalId( carreiraProfissionalId( carreira ) );

        return cadastraAtualizaCarreiraResponse;
    }

    @Override
    public void updateCarreira(CarreiraRequest request, Carreira carreira) {
        if ( request == null ) {
            return;
        }

        if ( request.getTransporte() != null ) {
            if ( carreira.getTransporte() == null ) {
                carreira.setTransporte( new Transporte() );
            }
            transporteRequestToTransporte1( request.getTransporte(), carreira.getTransporte() );
        }
        else {
            carreira.setTransporte( null );
        }
        if ( request.getUfConselho() != null ) {
            if ( carreira.getEstado() == null ) {
                carreira.setEstado( new Estado() );
            }
            ufConselhoRequestToEstado1( request.getUfConselho(), carreira.getEstado() );
        }
        else {
            carreira.setEstado( null );
        }
        if ( request.getConselho() != null ) {
            if ( carreira.getConselho() == null ) {
                carreira.setConselho( new Conselho() );
            }
            conselhoRequestToConselho1( request.getConselho(), carreira.getConselho() );
        }
        else {
            carreira.setConselho( null );
        }
        carreira.setId( request.getId() );
        carreira.setRegistroProfissional( request.getRegistroProfissional() );
        carreira.setNomeReferencia1( request.getNomeReferencia1() );
        carreira.setNomeReferencia2( request.getNomeReferencia2() );
        carreira.setTelefoneReferencia1( request.getTelefoneReferencia1() );
        carreira.setTelefoneReferencia2( request.getTelefoneReferencia2() );
        if ( carreira.getAreasAtendimento() != null ) {
            List<AreaAtendimento> list = areaAtendimentoRequestListToAreaAtendimentoList( request.getAreasAtendimento() );
            if ( list != null ) {
                carreira.getAreasAtendimento().clear();
                carreira.getAreasAtendimento().addAll( list );
            }
            else {
                carreira.setAreasAtendimento( null );
            }
        }
        else {
            List<AreaAtendimento> list = areaAtendimentoRequestListToAreaAtendimentoList( request.getAreasAtendimento() );
            if ( list != null ) {
                carreira.setAreasAtendimento( list );
            }
        }
    }

    protected Transporte transporteRequestToTransporte(TransporteRequest transporteRequest) {
        if ( transporteRequest == null ) {
            return null;
        }

        Transporte transporte = new Transporte();

        transporte.setId( transporteRequest.getId() );
        transporte.setTipo( transporteRequest.getTipo() );

        return transporte;
    }

    protected Estado ufConselhoRequestToEstado(UfConselhoRequest ufConselhoRequest) {
        if ( ufConselhoRequest == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setId( ufConselhoRequest.getId() );
        estado.setUf( ufConselhoRequest.getUf() );

        return estado;
    }

    protected Conselho conselhoRequestToConselho(ConselhoRequest conselhoRequest) {
        if ( conselhoRequest == null ) {
            return null;
        }

        Conselho conselho = new Conselho();

        conselho.setId( conselhoRequest.getId() );
        conselho.setSigla( conselhoRequest.getSigla() );
        conselho.setDescricao( conselhoRequest.getDescricao() );

        return conselho;
    }

    protected Profissional carreiraRequestToProfissional(CarreiraRequest carreiraRequest) {
        if ( carreiraRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( carreiraRequest.getProprietarioId() );

        return profissional;
    }

    protected AreaAtendimento areaAtendimentoRequestToAreaAtendimento(AreaAtendimentoRequest areaAtendimentoRequest) {
        if ( areaAtendimentoRequest == null ) {
            return null;
        }

        AreaAtendimento areaAtendimento = new AreaAtendimento();

        areaAtendimento.setId( areaAtendimentoRequest.getId() );
        areaAtendimento.setNome( areaAtendimentoRequest.getNome() );

        return areaAtendimento;
    }

    protected List<AreaAtendimento> areaAtendimentoRequestListToAreaAtendimentoList(List<AreaAtendimentoRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<AreaAtendimento> list1 = new ArrayList<AreaAtendimento>( list.size() );
        for ( AreaAtendimentoRequest areaAtendimentoRequest : list ) {
            list1.add( areaAtendimentoRequestToAreaAtendimento( areaAtendimentoRequest ) );
        }

        return list1;
    }

    private Long carreiraProfissionalId(Carreira carreira) {
        if ( carreira == null ) {
            return null;
        }
        Profissional profissional = carreira.getProfissional();
        if ( profissional == null ) {
            return null;
        }
        Long id = profissional.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void transporteRequestToTransporte1(TransporteRequest transporteRequest, Transporte mappingTarget) {
        if ( transporteRequest == null ) {
            return;
        }

        mappingTarget.setId( transporteRequest.getId() );
        mappingTarget.setTipo( transporteRequest.getTipo() );
    }

    protected void ufConselhoRequestToEstado1(UfConselhoRequest ufConselhoRequest, Estado mappingTarget) {
        if ( ufConselhoRequest == null ) {
            return;
        }

        mappingTarget.setId( ufConselhoRequest.getId() );
        mappingTarget.setUf( ufConselhoRequest.getUf() );
    }

    protected void conselhoRequestToConselho1(ConselhoRequest conselhoRequest, Conselho mappingTarget) {
        if ( conselhoRequest == null ) {
            return;
        }

        mappingTarget.setId( conselhoRequest.getId() );
        mappingTarget.setSigla( conselhoRequest.getSigla() );
        mappingTarget.setDescricao( conselhoRequest.getDescricao() );
    }
}
