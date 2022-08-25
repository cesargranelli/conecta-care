package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.DocumentoResponse;

public interface DocumentoConsultaService {
    DocumentoResponse consultar(Long documentoId);
}
