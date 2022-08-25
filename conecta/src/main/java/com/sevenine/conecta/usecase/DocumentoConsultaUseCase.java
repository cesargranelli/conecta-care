package com.sevenine.conecta.usecase;

import com.sevenine.conecta.services.data.response.DocumentoResponse;

public interface DocumentoConsultaUseCase {
    DocumentoResponse executar(Long documentoId);
}
