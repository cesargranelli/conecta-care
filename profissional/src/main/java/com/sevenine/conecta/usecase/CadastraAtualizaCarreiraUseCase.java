package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraUseCase {
    CadastraAtualizaCarreiraResponse executar(CarreiraRequest request);
}
