package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.DocumentoResponse;

public interface DocumentoConsultaService {
    DocumentoResponse consultar(Long documentoId);
}
