package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.controllers.data.response.atendimento.TipoAtendimentoResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoConverter;
import com.sevenine.conecta.repository.data.*;
import com.sevenine.conecta.services.data.response.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultaAtendimentoConverterImpl implements ConsultaAtendimentoConverter {

    @Override
    public AtendimentoDetalheResponse fromEntityData(Atendimento atendimento) {
        if (atendimento == null) {
            return null;
        }

        AtendimentoDetalheResponse atendimentoDetalheResponse = new AtendimentoDetalheResponse();

        atendimentoDetalheResponse.setTratamento(atendimentoToTratamentoResponse(atendimento));
        atendimentoDetalheResponse.setPaciente(atendimentoToPacienteResponse(atendimento));
        atendimentoDetalheResponse.setProfissional(atendimentoToProfissionalAtendimentoResponse(atendimento));
        atendimentoDetalheResponse.setPlantonista(atendimentoToPlantonistaResponse(atendimento));
        atendimentoDetalheResponse.setId(atendimento.getId());
        atendimentoDetalheResponse.setData(atendimento.getData());
        atendimentoDetalheResponse.setHora(atendimento.getHora());
        atendimentoDetalheResponse.setObservacao(atendimento.getObservacao());
        atendimentoDetalheResponse.setEndereco(enderecoToEnderecoResponse(atendimento.getEndereco()));
        atendimentoDetalheResponse.setValorHomeCare(atendimento.getValorHomeCare());
        atendimentoDetalheResponse.setValorProfissional(atendimento.getValorProfissional());
        atendimentoDetalheResponse.setValorPaciente(atendimento.getValorPaciente());
        atendimentoDetalheResponse.setValorAjudaCusto(atendimento.getValorAjudaCusto());
        atendimentoDetalheResponse.setGrupos(grupoEentityToResponseList(atendimento.getGrupos()));
        atendimentoDetalheResponse.setSituacoes(atendimentoSituacaoListToAtendimentoSituacaoResponseList(atendimento.getSituacoes()));
        atendimentoDetalheResponse.setProcedimento(procedimentoToProcedimentoResponse(atendimento.getProcedimento()));
        atendimentoDetalheResponse.setTipoAtendimento(especialidadeToTipoAtendimentoResponse(atendimento.getTipoAtendimento()));

        return atendimentoDetalheResponse;
    }

    private PacienteResponse atendimentoToPacienteResponse(Atendimento atendimento) {
        if (atendimento == null) {
            return null;
        }

        PacienteResponse pacienteResponse = new PacienteResponse();

        pacienteResponse.setId(atendimento.getPacienteId());

        return pacienteResponse;
    }

    protected TratamentoResponse atendimentoToTratamentoResponse(Atendimento atendimento) {
        if (atendimento == null) {
            return null;
        }

        TratamentoResponse tratamentoResponse = new TratamentoResponse();

        tratamentoResponse.setId(atendimento.getTratamentoId());

        return tratamentoResponse;
    }

    protected AtendimentoProfissionalResponse atendimentoToProfissionalAtendimentoResponse(Atendimento atendimento) {
        if (atendimento == null) {
            return null;
        }

        AtendimentoProfissionalResponse profissionalAtendimentoResponse = new AtendimentoProfissionalResponse();

        profissionalAtendimentoResponse.setId(atendimento.getProfissionalId());

        return profissionalAtendimentoResponse;
    }

    protected PlantonistaResponse atendimentoToPlantonistaResponse(Atendimento atendimento) {
        if (atendimento == null) {
            return null;
        }

        PlantonistaResponse plantonistaResponse = new PlantonistaResponse();

        plantonistaResponse.setId(atendimento.getPlantonistaId());

        return plantonistaResponse;
    }

    protected EstadoResponse estadoToEstadoResponse(Estado estado) {
        if (estado == null) {
            return null;
        }

        EstadoResponse estadoResponse = new EstadoResponse();

        estadoResponse.setId(estado.getId());
        estadoResponse.setCodigo(estado.getCodigo());
        estadoResponse.setUf(estado.getUf());
        estadoResponse.setNome(estado.getNome());
        estadoResponse.setRegiao(estado.getRegiao());

        return estadoResponse;
    }

    protected PaisResponse paisToPaisResponse(Pais pais) {
        if (pais == null) {
            return null;
        }

        PaisResponse paisResponse = new PaisResponse();

        paisResponse.setId(pais.getId());
        paisResponse.setCodigo(pais.getCodigo());
        paisResponse.setNome(pais.getNome());

        return paisResponse;
    }

    protected EnderecoResponse enderecoToEnderecoResponse(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        EnderecoResponse enderecoResponse = new EnderecoResponse();

        enderecoResponse.setId(endereco.getId());
        enderecoResponse.setLogradouro(endereco.getLogradouro());
        enderecoResponse.setNumero(endereco.getNumero());
        enderecoResponse.setComplemento(endereco.getComplemento());
        enderecoResponse.setBairro(endereco.getBairro());
        enderecoResponse.setCidade(endereco.getCidade());
        enderecoResponse.setCep(endereco.getCep());
        enderecoResponse.setEstado(estadoToEstadoResponse(endereco.getEstado()));
        enderecoResponse.setPais(paisToPaisResponse(endereco.getPais()));

        return enderecoResponse;
    }

    protected List<GrupoResponse> grupoEentityToResponseList(List<Grupo> grupoList) {
        List<GrupoResponse> grupoResponseList = new ArrayList<>();

        for (Grupo grupo : grupoList) {
            GrupoResponse grupoResponse = new GrupoResponse();
            grupoResponse.setId(grupo.getId());
            grupoResponse.setDescricao(grupo.getDescricao());

            ModeloResponse modeloResponse = new ModeloResponse();
            modeloResponse.setId(grupo.getModelo().getId());
            modeloResponse.setDescricao(grupo.getModelo().getDescricao());

            grupoResponse.setModelo(modeloResponse);

            List<SubgrupoResponse> subgrupoResponseList = new ArrayList<>();
            for (Subgrupo subgrupo : grupo.getSubgrupos()) {
                SubgrupoResponse subgrupoResponse = new SubgrupoResponse();
                subgrupoResponse.setId(subgrupo.getId());
                subgrupoResponse.setDescricao(subgrupo.getDescricao());

                List<CampoResponse> campoResponseList = new ArrayList<>();
                for (Campo campo : subgrupo.getCampos()) {
                    CampoResponse campoResponse = new CampoResponse();
                    campoResponse.setId(subgrupo.getId());
                    campoResponse.setTipo(campo.getTipo());
                    campoResponse.setTamanho(campoResponse.getTamanho());
                    campoResponse.setPre(campoResponse.getPre());
                    campoResponse.setPos(campoResponse.getPos());
                    campoResponseList.add(campoResponse);
                }
                subgrupoResponse.setCampos(campoResponseList.stream().sorted(Comparator.comparing(CampoResponse::getId)).collect(Collectors.toList()));
                subgrupoResponseList.add(subgrupoResponse);
            }
            grupoResponse.setSubgrupos(subgrupoResponseList.stream().sorted(Comparator.comparing(SubgrupoResponse::getId)).collect(Collectors.toList()));
            grupoResponseList.add(grupoResponse);
        }
        return grupoResponseList.stream().sorted(Comparator.comparing(GrupoResponse::getId)).collect(Collectors.toList());
    }

    protected StatusAtendimentoResponse statusAtendimentoToStatusAtendimentoResponse(StatusAtendimento statusAtendimento) {
        if (statusAtendimento == null) {
            return null;
        }

        StatusAtendimentoResponse statusAtendimentoResponse = new StatusAtendimentoResponse();

        statusAtendimentoResponse.setId(statusAtendimento.getId());
        statusAtendimentoResponse.setDescricao(statusAtendimento.getDescricao());

        return statusAtendimentoResponse;
    }

    protected AtendimentoSituacaoResponse atendimentoSituacaoToAtendimentoSituacaoResponse(AtendimentoSituacao atendimentoSituacao) {
        if (atendimentoSituacao == null) {
            return null;
        }

        AtendimentoSituacaoResponse atendimentoSituacaoResponse = new AtendimentoSituacaoResponse();

        atendimentoSituacaoResponse.setId(atendimentoSituacao.getId());
        atendimentoSituacaoResponse.setStatus(statusAtendimentoToStatusAtendimentoResponse(atendimentoSituacao.getStatus()));
        atendimentoSituacaoResponse.setDataHora(atendimentoSituacao.getDataHora());

        return atendimentoSituacaoResponse;
    }

    protected List<AtendimentoSituacaoResponse> atendimentoSituacaoListToAtendimentoSituacaoResponseList(List<AtendimentoSituacao> list) {
        if (list == null) {
            return null;
        }

        List<AtendimentoSituacaoResponse> list1 = new ArrayList<AtendimentoSituacaoResponse>(list.size());
        for (AtendimentoSituacao atendimentoSituacao : list) {
            list1.add(atendimentoSituacaoToAtendimentoSituacaoResponse(atendimentoSituacao));
        }

        return list1;
    }

    protected ProcedimentoResponse procedimentoToProcedimentoResponse(Procedimento procedimento) {
        if (procedimento == null) {
            return null;
        }

        ProcedimentoResponse procedimentoResponse = new ProcedimentoResponse();

        procedimentoResponse.setId(procedimento.getId());
        procedimentoResponse.setDescricao(procedimento.getDescricao());

        return procedimentoResponse;
    }

    protected TipoAtendimentoResponse especialidadeToTipoAtendimentoResponse(Especialidade especialidade) {
        if (especialidade == null) {
            return null;
        }

        TipoAtendimentoResponse tipoAtendimentoResponse = new TipoAtendimentoResponse();

        tipoAtendimentoResponse.setId(especialidade.getId());
        tipoAtendimentoResponse.setNome(especialidade.getNome());

        return tipoAtendimentoResponse;
    }

}
