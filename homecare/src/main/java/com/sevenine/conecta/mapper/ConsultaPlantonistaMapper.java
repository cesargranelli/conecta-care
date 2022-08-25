package com.sevenine.conecta.mapper;

import com.sevenine.conecta.repository.data.Plantonista;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaPlantonistaMapper {
    PlantonistaResponse fromEntityData(Plantonista plantonista);
}
