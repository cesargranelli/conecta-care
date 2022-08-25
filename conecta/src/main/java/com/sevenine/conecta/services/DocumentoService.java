package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.controllers.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.services.data.response.DocumentoResponse;

public interface DocumentoService {
    DocumentoResponse pesquisar(CadastraDocumentoRequest request);

    CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request);

    DocumentoConsultaResponse buscar(Long documentoId);
}
