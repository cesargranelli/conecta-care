package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.DocumentoRequest;
import com.sevenine.conecta.controller.data.response.DocumentoCadastraResponse;
import com.sevenine.conecta.controller.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.service.data.response.DocumentoResponse;

public interface DocumentoService {
    DocumentoCadastraResponse cadastrar(DocumentoRequest request);

    DocumentoResponse pesquisar(DocumentoRequest request);

    DocumentoConsultaResponse buscar(Long documentoId);
}
