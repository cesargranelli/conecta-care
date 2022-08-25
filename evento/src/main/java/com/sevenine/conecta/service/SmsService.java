package com.sevenine.conecta.services;

public interface SmsService {
    void enviar(Long idProfissional, String numeroTelefone);
}
