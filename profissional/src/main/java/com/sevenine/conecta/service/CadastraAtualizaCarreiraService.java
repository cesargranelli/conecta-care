package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.CarreiraRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraService {
    CadastraAtualizaCarreiraResponse salvar(CarreiraRequest request);
}
