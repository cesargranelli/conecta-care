package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.mapper.ConsultaPlantonistaMapper;
import com.sevenine.conecta.repository.data.Plantonista;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-19T22:58:19-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaPlantonistaMapperImpl implements ConsultaPlantonistaMapper {

    @Override
    public PlantonistaResponse fromEntityData(Plantonista plantonista) {
        if ( plantonista == null ) {
            return null;
        }

        PlantonistaResponse plantonistaResponse = new PlantonistaResponse();

        plantonistaResponse.setId( plantonista.getId() );
        plantonistaResponse.setNome( plantonista.getNome() );
        plantonistaResponse.setContato( plantonista.getContato() );

        return plantonistaResponse;
    }
}
