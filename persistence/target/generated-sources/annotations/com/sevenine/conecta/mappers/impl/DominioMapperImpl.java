package com.sevenine.conecta.mappers.impl;

import com.sevenine.conecta.domain.entities.AreaAtendimento;
import com.sevenine.conecta.domain.entities.Banco;
import com.sevenine.conecta.domain.entities.CategoriaCnh;
import com.sevenine.conecta.domain.entities.Conselho;
import com.sevenine.conecta.domain.entities.Estado;
import com.sevenine.conecta.domain.entities.EstadoCivil;
import com.sevenine.conecta.domain.entities.Genero;
import com.sevenine.conecta.domain.entities.Grupo;
import com.sevenine.conecta.domain.entities.Instrucao;
import com.sevenine.conecta.domain.entities.Modelo;
import com.sevenine.conecta.domain.entities.Pais;
import com.sevenine.conecta.domain.entities.Parentesco;
import com.sevenine.conecta.domain.entities.TipoConta;
import com.sevenine.conecta.domain.entities.TipoEmpresa;
import com.sevenine.conecta.domain.entities.Transporte;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.datas.AreaAtendimentoData;
import com.sevenine.conecta.repositories.datas.BancoData;
import com.sevenine.conecta.repositories.datas.CategoriaCnhData;
import com.sevenine.conecta.repositories.datas.ConselhoData;
import com.sevenine.conecta.repositories.datas.EstadoCivilData;
import com.sevenine.conecta.repositories.datas.EstadoData;
import com.sevenine.conecta.repositories.datas.GeneroData;
import com.sevenine.conecta.repositories.datas.GrupoData;
import com.sevenine.conecta.repositories.datas.InstrucaoData;
import com.sevenine.conecta.repositories.datas.ModeloData;
import com.sevenine.conecta.repositories.datas.PaisData;
import com.sevenine.conecta.repositories.datas.ParentescoData;
import com.sevenine.conecta.repositories.datas.TipoContaData;
import com.sevenine.conecta.repositories.datas.TipoEmpresaData;
import com.sevenine.conecta.repositories.datas.TransporteData;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T22:03:15-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class DominioMapperImpl implements DominioMapper {

    @Override
    public List<AreaAtendimento> toAreaAtendimento(List<AreaAtendimentoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<AreaAtendimento> list = new ArrayList<AreaAtendimento>( dataList.size() );
        for ( AreaAtendimentoData areaAtendimentoData : dataList ) {
            list.add( areaAtendimentoDataToAreaAtendimento( areaAtendimentoData ) );
        }

        return list;
    }

    @Override
    public List<Banco> toBanco(List<BancoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Banco> list = new ArrayList<Banco>( dataList.size() );
        for ( BancoData bancoData : dataList ) {
            list.add( bancoDataToBanco( bancoData ) );
        }

        return list;
    }

    @Override
    public List<CategoriaCnh> toCategoriaCnh(List<CategoriaCnhData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<CategoriaCnh> list = new ArrayList<CategoriaCnh>( dataList.size() );
        for ( CategoriaCnhData categoriaCnhData : dataList ) {
            list.add( categoriaCnhDataToCategoriaCnh( categoriaCnhData ) );
        }

        return list;
    }

    @Override
    public List<Conselho> toConselho(List<ConselhoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Conselho> list = new ArrayList<Conselho>( dataList.size() );
        for ( ConselhoData conselhoData : dataList ) {
            list.add( conselhoDataToConselho( conselhoData ) );
        }

        return list;
    }

    @Override
    public List<Estado> toEstado(List<EstadoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Estado> list = new ArrayList<Estado>( dataList.size() );
        for ( EstadoData estadoData : dataList ) {
            list.add( estadoDataToEstado( estadoData ) );
        }

        return list;
    }

    @Override
    public List<EstadoCivil> toEstadoCivil(List<EstadoCivilData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<EstadoCivil> list = new ArrayList<EstadoCivil>( dataList.size() );
        for ( EstadoCivilData estadoCivilData : dataList ) {
            list.add( estadoCivilDataToEstadoCivil( estadoCivilData ) );
        }

        return list;
    }

    @Override
    public List<Genero> toGenero(List<GeneroData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Genero> list = new ArrayList<Genero>( dataList.size() );
        for ( GeneroData generoData : dataList ) {
            list.add( generoDataToGenero( generoData ) );
        }

        return list;
    }

    @Override
    public List<Grupo> toGrupo(List<GrupoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Grupo> list = new ArrayList<Grupo>( dataList.size() );
        for ( GrupoData grupoData : dataList ) {
            list.add( grupoDataToGrupo( grupoData ) );
        }

        return list;
    }

    @Override
    public List<Instrucao> toInstrucao(List<InstrucaoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Instrucao> list = new ArrayList<Instrucao>( dataList.size() );
        for ( InstrucaoData instrucaoData : dataList ) {
            list.add( instrucaoDataToInstrucao( instrucaoData ) );
        }

        return list;
    }

    @Override
    public List<Modelo> toModelo(List<ModeloData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Modelo> list = new ArrayList<Modelo>( dataList.size() );
        for ( ModeloData modeloData : dataList ) {
            list.add( modeloDataToModelo( modeloData ) );
        }

        return list;
    }

    @Override
    public List<Pais> toPais(List<PaisData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Pais> list = new ArrayList<Pais>( dataList.size() );
        for ( PaisData paisData : dataList ) {
            list.add( paisDataToPais( paisData ) );
        }

        return list;
    }

    @Override
    public List<Parentesco> toParentesco(List<ParentescoData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Parentesco> list = new ArrayList<Parentesco>( dataList.size() );
        for ( ParentescoData parentescoData : dataList ) {
            list.add( parentescoDataToParentesco( parentescoData ) );
        }

        return list;
    }

    @Override
    public List<TipoConta> toTipoConta(List<TipoContaData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<TipoConta> list = new ArrayList<TipoConta>( dataList.size() );
        for ( TipoContaData tipoContaData : dataList ) {
            list.add( tipoContaDataToTipoConta( tipoContaData ) );
        }

        return list;
    }

    @Override
    public List<TipoEmpresa> toTipoEmpresa(List<TipoEmpresaData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<TipoEmpresa> list = new ArrayList<TipoEmpresa>( dataList.size() );
        for ( TipoEmpresaData tipoEmpresaData : dataList ) {
            list.add( tipoEmpresaDataToTipoEmpresa( tipoEmpresaData ) );
        }

        return list;
    }

    @Override
    public List<Transporte> toTransporte(List<TransporteData> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<Transporte> list = new ArrayList<Transporte>( dataList.size() );
        for ( TransporteData transporteData : dataList ) {
            list.add( transporteDataToTransporte( transporteData ) );
        }

        return list;
    }

    protected AreaAtendimento areaAtendimentoDataToAreaAtendimento(AreaAtendimentoData areaAtendimentoData) {
        if ( areaAtendimentoData == null ) {
            return null;
        }

        AreaAtendimento areaAtendimento = new AreaAtendimento();

        areaAtendimento.setId( areaAtendimentoData.getId() );
        areaAtendimento.setNome( areaAtendimentoData.getNome() );

        return areaAtendimento;
    }

    protected Banco bancoDataToBanco(BancoData bancoData) {
        if ( bancoData == null ) {
            return null;
        }

        Banco banco = new Banco();

        banco.setId( bancoData.getId() );
        banco.setCodigo( bancoData.getCodigo() );
        banco.setDescricao( bancoData.getDescricao() );

        return banco;
    }

    protected CategoriaCnh categoriaCnhDataToCategoriaCnh(CategoriaCnhData categoriaCnhData) {
        if ( categoriaCnhData == null ) {
            return null;
        }

        CategoriaCnh categoriaCnh = new CategoriaCnh();

        categoriaCnh.setId( categoriaCnhData.getId() );
        categoriaCnh.setSigla( categoriaCnhData.getSigla() );
        categoriaCnh.setDescricao( categoriaCnhData.getDescricao() );

        return categoriaCnh;
    }

    protected Conselho conselhoDataToConselho(ConselhoData conselhoData) {
        if ( conselhoData == null ) {
            return null;
        }

        Conselho conselho = new Conselho();

        conselho.setId( conselhoData.getId() );
        conselho.setSigla( conselhoData.getSigla() );
        conselho.setDescricao( conselhoData.getDescricao() );

        return conselho;
    }

    protected Estado estadoDataToEstado(EstadoData estadoData) {
        if ( estadoData == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setId( estadoData.getId() );
        estado.setCodigo( estadoData.getCodigo() );
        estado.setUf( estadoData.getUf() );
        estado.setNome( estadoData.getNome() );
        estado.setRegiao( estadoData.getRegiao() );

        return estado;
    }

    protected EstadoCivil estadoCivilDataToEstadoCivil(EstadoCivilData estadoCivilData) {
        if ( estadoCivilData == null ) {
            return null;
        }

        EstadoCivil estadoCivil = new EstadoCivil();

        estadoCivil.setId( estadoCivilData.getId() );
        estadoCivil.setTipo( estadoCivilData.getTipo() );
        estadoCivil.setDescricao( estadoCivilData.getDescricao() );

        return estadoCivil;
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

    protected Grupo grupoDataToGrupo(GrupoData grupoData) {
        if ( grupoData == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setId( grupoData.getId() );
        grupo.setDescricao( grupoData.getDescricao() );

        return grupo;
    }

    protected Instrucao instrucaoDataToInstrucao(InstrucaoData instrucaoData) {
        if ( instrucaoData == null ) {
            return null;
        }

        Instrucao instrucao = new Instrucao();

        instrucao.setId( instrucaoData.getId() );
        instrucao.setGrau( instrucaoData.getGrau() );

        return instrucao;
    }

    protected Modelo modeloDataToModelo(ModeloData modeloData) {
        if ( modeloData == null ) {
            return null;
        }

        Modelo modelo = new Modelo();

        modelo.setId( modeloData.getId() );
        modelo.setDescricao( modeloData.getDescricao() );

        return modelo;
    }

    protected Pais paisDataToPais(PaisData paisData) {
        if ( paisData == null ) {
            return null;
        }

        Pais pais = new Pais();

        pais.setId( paisData.getId() );
        pais.setCodigo( paisData.getCodigo() );
        pais.setNome( paisData.getNome() );

        return pais;
    }

    protected Parentesco parentescoDataToParentesco(ParentescoData parentescoData) {
        if ( parentescoData == null ) {
            return null;
        }

        Parentesco parentesco = new Parentesco();

        parentesco.setId( parentescoData.getId() );
        parentesco.setDescricao( parentescoData.getDescricao() );

        return parentesco;
    }

    protected TipoConta tipoContaDataToTipoConta(TipoContaData tipoContaData) {
        if ( tipoContaData == null ) {
            return null;
        }

        TipoConta tipoConta = new TipoConta();

        tipoConta.setId( tipoContaData.getId() );
        tipoConta.setCodigo( tipoContaData.getCodigo() );
        tipoConta.setDescricao( tipoContaData.getDescricao() );

        return tipoConta;
    }

    protected TipoEmpresa tipoEmpresaDataToTipoEmpresa(TipoEmpresaData tipoEmpresaData) {
        if ( tipoEmpresaData == null ) {
            return null;
        }

        TipoEmpresa tipoEmpresa = new TipoEmpresa();

        tipoEmpresa.setId( tipoEmpresaData.getId() );
        tipoEmpresa.setSigla( tipoEmpresaData.getSigla() );
        tipoEmpresa.setTipo( tipoEmpresaData.getTipo() );
        tipoEmpresa.setDescricao( tipoEmpresaData.getDescricao() );

        return tipoEmpresa;
    }

    protected Transporte transporteDataToTransporte(TransporteData transporteData) {
        if ( transporteData == null ) {
            return null;
        }

        Transporte transporte = new Transporte();

        transporte.setId( transporteData.getId() );
        transporte.setTipo( transporteData.getTipo() );

        return transporte;
    }
}
