package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ListaEspecialidadeResponse;
import com.sevenine.conecta.controller.data.response.ListaProfissionalResponse;
import com.sevenine.conecta.mapper.ListaProfissionalMapper;
import com.sevenine.conecta.repository.data.AreaAtendimento;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.repository.data.Conselho;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.ListaProfissional;
import com.sevenine.conecta.repository.data.Telefone;
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
public class ListaProfissionalMapperImpl implements ListaProfissionalMapper {

    @Override
    public ListaProfissionalResponse fromEntityData(ListaProfissional profissional) {
        if ( profissional == null ) {
            return null;
        }

        ListaProfissionalResponse listaProfissionalResponse = new ListaProfissionalResponse();

        listaProfissionalResponse.setFoto( profissional.getFotoProfissional() );
        listaProfissionalResponse.setConselho( profissionalCarreiraConselhoSigla( profissional ) );
        listaProfissionalResponse.setConselhoUf( profissionalCarreiraEstadoUf( profissional ) );
        Long registroProfissional = profissionalCarreiraRegistroProfissional( profissional );
        if ( registroProfissional != null ) {
            listaProfissionalResponse.setRegistro( String.valueOf( registroProfissional ) );
        }
        listaProfissionalResponse.setCelular( profissionalTelefoneCelularPrincipal( profissional ) );
        List<AreaAtendimento> areasAtendimento = profissionalCarreiraAreasAtendimento( profissional );
        listaProfissionalResponse.setEspecialidades( areaAtendimentoListToListaEspecialidadeResponseList( areasAtendimento ) );
        listaProfissionalResponse.setId( profissional.getId() );
        listaProfissionalResponse.setCpf( profissional.getCpf() );
        listaProfissionalResponse.setNome( profissional.getNome() );
        listaProfissionalResponse.setSobrenome( profissional.getSobrenome() );

        return listaProfissionalResponse;
    }

    @Override
    public List<ListaProfissionalResponse> fromEntityDataList(List<ListaProfissional> profissionais) {
        if ( profissionais == null ) {
            return null;
        }

        List<ListaProfissionalResponse> list = new ArrayList<ListaProfissionalResponse>( profissionais.size() );
        for ( ListaProfissional listaProfissional : profissionais ) {
            list.add( fromEntityData( listaProfissional ) );
        }

        return list;
    }

    private String profissionalCarreiraConselhoSigla(ListaProfissional listaProfissional) {
        if ( listaProfissional == null ) {
            return null;
        }
        Carreira carreira = listaProfissional.getCarreira();
        if ( carreira == null ) {
            return null;
        }
        Conselho conselho = carreira.getConselho();
        if ( conselho == null ) {
            return null;
        }
        String sigla = conselho.getSigla();
        if ( sigla == null ) {
            return null;
        }
        return sigla;
    }

    private String profissionalCarreiraEstadoUf(ListaProfissional listaProfissional) {
        if ( listaProfissional == null ) {
            return null;
        }
        Carreira carreira = listaProfissional.getCarreira();
        if ( carreira == null ) {
            return null;
        }
        Estado estado = carreira.getEstado();
        if ( estado == null ) {
            return null;
        }
        String uf = estado.getUf();
        if ( uf == null ) {
            return null;
        }
        return uf;
    }

    private Long profissionalCarreiraRegistroProfissional(ListaProfissional listaProfissional) {
        if ( listaProfissional == null ) {
            return null;
        }
        Carreira carreira = listaProfissional.getCarreira();
        if ( carreira == null ) {
            return null;
        }
        Long registroProfissional = carreira.getRegistroProfissional();
        if ( registroProfissional == null ) {
            return null;
        }
        return registroProfissional;
    }

    private String profissionalTelefoneCelularPrincipal(ListaProfissional listaProfissional) {
        if ( listaProfissional == null ) {
            return null;
        }
        Telefone telefone = listaProfissional.getTelefone();
        if ( telefone == null ) {
            return null;
        }
        String celularPrincipal = telefone.getCelularPrincipal();
        if ( celularPrincipal == null ) {
            return null;
        }
        return celularPrincipal;
    }

    private List<AreaAtendimento> profissionalCarreiraAreasAtendimento(ListaProfissional listaProfissional) {
        if ( listaProfissional == null ) {
            return null;
        }
        Carreira carreira = listaProfissional.getCarreira();
        if ( carreira == null ) {
            return null;
        }
        List<AreaAtendimento> areasAtendimento = carreira.getAreasAtendimento();
        if ( areasAtendimento == null ) {
            return null;
        }
        return areasAtendimento;
    }

    protected ListaEspecialidadeResponse areaAtendimentoToListaEspecialidadeResponse(AreaAtendimento areaAtendimento) {
        if ( areaAtendimento == null ) {
            return null;
        }

        ListaEspecialidadeResponse listaEspecialidadeResponse = new ListaEspecialidadeResponse();

        listaEspecialidadeResponse.setId( areaAtendimento.getId() );
        listaEspecialidadeResponse.setNome( areaAtendimento.getNome() );

        return listaEspecialidadeResponse;
    }

    protected List<ListaEspecialidadeResponse> areaAtendimentoListToListaEspecialidadeResponseList(List<AreaAtendimento> list) {
        if ( list == null ) {
            return null;
        }

        List<ListaEspecialidadeResponse> list1 = new ArrayList<ListaEspecialidadeResponse>( list.size() );
        for ( AreaAtendimento areaAtendimento : list ) {
            list1.add( areaAtendimentoToListaEspecialidadeResponse( areaAtendimento ) );
        }

        return list1;
    }
}
