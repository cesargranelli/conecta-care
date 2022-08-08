package com.sevenine.conecta.usecase;

import com.sevenine.conecta.service.data.response.DocumentoResponse;

public interface DocumentoConsultaUseCase {
    DocumentoResponse executar(Long documentoId);
}
