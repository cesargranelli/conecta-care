package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.CarreiraRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraUseCase {
    CadastraAtualizaCarreiraResponse executar(CarreiraRequest request);
}
