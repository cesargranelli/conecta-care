package com.sevenine.conecta.mappers;

import com.sevenine.conecta.domain.entities.Genero;
import com.sevenine.conecta.repositories.datas.GeneroData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface GeneroMapper {

    GeneroMapper INSTANCE = Mappers.getMapper(GeneroMapper.class);

    List<Genero> toOutput(List<GeneroData> dataList);

}
