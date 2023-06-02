package com.sevenine.conecta.converter.cadastro;

import com.sevenine.conecta.adapter.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.repository.data.Complemento;

public interface CadastraAtualizaComplementoConverter {
    Complemento toEntityData(ComplementoRequest request);
}
