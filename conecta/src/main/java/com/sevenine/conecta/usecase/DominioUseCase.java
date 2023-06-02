package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaAreaAtendimentoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaBancoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaCategoriaCnhResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaConselhoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaEstadoCivilResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaEstadoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaInstrucaoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaModeloResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaPaisResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaParentescoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaStatusAtendimentoResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoContaResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoEmpresaResponse;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaTransporteResponse;
import com.sevenine.conecta.services.AreaAtendimentoService;
import com.sevenine.conecta.services.BancoService;
import com.sevenine.conecta.services.CategoriaCnhService;
import com.sevenine.conecta.services.ConselhoService;
import com.sevenine.conecta.services.EstadoCivilService;
import com.sevenine.conecta.services.EstadoService;
import com.sevenine.conecta.services.GeneroServiceTest;
import com.sevenine.conecta.services.GrupoService;
import com.sevenine.conecta.services.InstrucaoService;
import com.sevenine.conecta.services.ModeloService;
import com.sevenine.conecta.services.PaisService;
import com.sevenine.conecta.services.ParentescoService;
import com.sevenine.conecta.services.StatusAtendimentoService;
import com.sevenine.conecta.services.TipoContaService;
import com.sevenine.conecta.services.TipoEmpresaService;
import com.sevenine.conecta.services.TransporteService;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DominioUseCase {

    private final GeneroServiceTest generoServiceTest;
    private final TipoEmpresaService tipoEmpresaService;
    private final EstadoCivilService estadoCivilService;
    private final EstadoService estadoService;
    private final ConselhoService conselhoService;
    private final AreaAtendimentoService areaAtendimentoService;
    private final TransporteService transporteService;
    private final InstrucaoService instrucaoService;
    private final CategoriaCnhService categoriaCnhService;
    private final TipoContaService tipoContaService;
    private final BancoService bancoService;
    private final PaisService paisService;
    private final ParentescoService parentescoService;
    private final ModeloService modeloService;
    private final GrupoService grupoService;
    private final StatusAtendimentoService statusAtendimentoService;

//    public List<ConsultaGeneroResponse> consultarGeneros() {
//        return generoServiceTest.consultar();
//    }

    public List<ConsultaTipoEmpresaResponse> consultarTiposEmpresas() {
        return tipoEmpresaService.consultar();
    }

    public List<ConsultaEstadoCivilResponse> consultarEstadosCivis() {
        return estadoCivilService.consultar();
    }

    public List<ConsultaEstadoResponse> consultarEstados() {
        return estadoService.consultar();
    }

    public List<ConsultaConselhoResponse> consultarConselhos() {
        return conselhoService.consultar();
    }

    public List<ConsultaAreaAtendimentoResponse> consultarAreasAtendimentos() {
        return areaAtendimentoService.consultar();
    }

    public List<ConsultaTransporteResponse> consultarTransportes() {
        return transporteService.consultar();
    }

    public List<ConsultaInstrucaoResponse> consultarInstrucoes() {
        return instrucaoService.consultar();
    }

    public List<ConsultaCategoriaCnhResponse> consultarCategoriasCnh() {
        return categoriaCnhService.consultar();
    }

    public List<ConsultaTipoContaResponse> consultarTiposContas() {
        return tipoContaService.consultar();
    }

    public List<ConsultaBancoResponse> consultarBancos() {
        return bancoService.consultar();
    }

    public List<ConsultaPaisResponse> consultarPaises() {
        return paisService.consultar();
    }

    public List<ConsultaParentescoResponse> consultarParentescos() {
        return parentescoService.consultar();
    }

    public List<ConsultaModeloResponse> consultarModelos() {
        return modeloService.consultar();
    }

    public List<ConsultaGrupoResponse> consultarGrupos() {
        return grupoService.consultar();
    }

    public List<ConsultaStatusAtendimentoResponse> consultarStatusAtendimentos() {
        return statusAtendimentoService.consultar();
    }
    
}
