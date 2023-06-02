package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraUseCase {
    CadastraAtualizaCarreiraResponse executar(CarreiraRequest request);
}
