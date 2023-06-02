package com.sevenine.conecta.mapper;

import com.sevenine.conecta.domain.model.*;
import com.sevenine.conecta.repository.datas.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface DominioMapper {

    DominioMapper INSTANCE = Mappers.getMapper(DominioMapper.class);

    List<AreaAtendimento> toAreaAtendimento(List<AreaAtendimentoData> dataList);

    List<Banco> toBanco(List<BancoData> dataList);

    List<CategoriaCnh> toCategoriaCnh(List<CategoriaCnhData> dataList);

    List<Conselho> toConselho(List<ConselhoData> dataList);

    List<Estado> toEstado(List<EstadoData> dataList);

    List<EstadoCivil> toEstadoCivil(List<EstadoCivilData> dataList);

    List<Genero> toGenero(List<GeneroData> dataList);

    List<Grupo> toGrupo(List<GrupoData> dataList);

    List<Instrucao> toInstrucao(List<InstrucaoData> dataList);

    List<Modelo> toModelo(List<ModeloData> dataList);

    List<Pais> toPais(List<PaisData> dataList);

    List<Parentesco> toParentesco(List<ParentescoData> dataList);

    List<TipoConta> toTipoConta(List<TipoContaData> dataList);

    List<TipoEmpresa> toTipoEmpresa(List<TipoEmpresaData> dataList);

    List<Transporte> toTransporte(List<TransporteData> dataList);

}
