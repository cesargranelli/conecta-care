package com.sevenine.conecta.mapper;

import com.sevenine.conecta.repository.data.Plantonista;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface ConsultaListaPlantonistaMapper {
    List<PlantonistaResponse> fromEntityDataList(List<Plantonista> plantonistas);
}
