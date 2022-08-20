package com.connecta.evento.service.impl;

import com.connecta.evento.service.EventoEnviaService;
import com.connecta.evento.service.SmsService;
import com.connecta.evento.service.data.request.EventoEnviaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Log
@RequiredArgsConstructor
@Service
public class EventoEnviaServiceImpl implements EventoEnviaService {

    private final SmsService smsService;

    @Override
    public Integer enviar(List<EventoEnviaRequest> requestList) {
        final AtomicInteger quantidadeEnviados = new AtomicInteger();
        final AtomicInteger quantidadeFalhas = new AtomicInteger();

        requestList.forEach(dadosProfissional -> {
            try {
                smsService.enviar(dadosProfissional.getProfissionalId(), dadosProfissional.getNumeroTelefone());
                quantidadeEnviados.getAndIncrement();
            } catch (Exception e) {
                quantidadeFalhas.getAndIncrement();
            }
        });

        log.info(String.format("Total de SMSs enviados com sucesso: %d", quantidadeEnviados.get()));
        log.info(String.format("Total de SMSs problema no envio: %d", quantidadeFalhas.get()));

        return quantidadeEnviados.get();
    }

}
