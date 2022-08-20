package com.connecta.evento.usecase.impl;

import com.connecta.evento.controller.data.response.EnvioResponse;
import com.connecta.evento.controller.data.response.EspecialidadeResponse;
import com.connecta.evento.controller.data.response.EventoResponse;
import com.connecta.evento.mapper.EventoEnviaMapper;
import com.connecta.evento.service.EventoConsultaService;
import com.connecta.evento.service.EventoEnviaService;
import com.connecta.evento.service.ProfissionalEventoService;
import com.connecta.evento.service.data.response.ProfissionalEventoResponse;
import com.connecta.evento.usecase.EventoEnviaUseCase;
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
