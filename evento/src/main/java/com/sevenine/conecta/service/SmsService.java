package com.connecta.evento.service;

public interface SmsService {
    void enviar(Long idProfissional, String numeroTelefone);
}
