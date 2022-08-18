package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.controller.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.controller.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.service.data.response.DocumentoResponse;

public interface DocumentoService {
    DocumentoResponse pesquisar(CadastraDocumentoRequest request);

    CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request);

    DocumentoConsultaResponse buscar(Long documentoId);
}
