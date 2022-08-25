package com.sevenine.conecta.mappers.impl;

import com.sevenine.conecta.domain.entities.Genero;
import com.sevenine.conecta.mappers.GeneroMapper;
import com.sevenine.conecta.repositories.datas.GeneroData;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T20:43:44-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class GeneroMapperImpl implements GeneroMapper {

    @Override
    public List<Genero> toOutput(List<GeneroData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Genero> list = new ArrayList<Genero>( dataList.size() );
        for ( GeneroData generoData : dataList ) {
            list.add( generoDataToGenero( generoData ) );
        }

        return list;
    }

    protected Genero generoDataToGenero(GeneroData generoData) {
        if ( generoData == null ) {
            return null;
        }

        Genero genero = new Genero();

        genero.setId( generoData.getId() );
        genero.setTipo( generoData.getTipo() );
        genero.setDescricao( generoData.getDescricao() );

        return genero;
    }
}
