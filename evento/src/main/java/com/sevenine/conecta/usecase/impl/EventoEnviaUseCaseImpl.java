package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.EnvioResponse;
import com.sevenine.conecta.adapter.controller.data.response.EspecialidadeResponse;
import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;
import com.sevenine.conecta.mapper.EventoEnviaMapper;
import com.sevenine.conecta.services.EventoConsultaService;
import com.sevenine.conecta.services.EventoEnviaService;
import com.sevenine.conecta.services.ProfissionalEventoService;
import com.sevenine.conecta.services.data.response.ProfissionalEventoResponse;
import com.sevenine.conecta.usecase.EventoEnviaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventoEnviaUseCaseImpl implements EventoEnviaUseCase {

    private final EventoEnviaMapper mapper;

    private final EventoConsultaService eventoConsultaService;
    private final ProfissionalEventoService profissionalEventoService;
    private final EventoEnviaService eventoEnviaService;

    @Override
    public EnvioResponse executar(long idEvento) {
        EventoResponse evento = eventoConsultaService.consultar(idEvento);

        List<ProfissionalEventoResponse> profissionaisEvento =
                profissionalEventoService.pesquisar(idsEspecialidades(evento), evento.getEstado().getId());

        return mapper.fromQuantidadeEnviados(eventoEnviaService.enviar(mapper.toRequest(profissionaisEvento)));
    }

    private List<Long> idsEspecialidades(EventoResponse evento) {
        return evento.getEspecialidades().stream().map(EspecialidadeResponse::getId).collect(Collectors.toList());
    }

}
