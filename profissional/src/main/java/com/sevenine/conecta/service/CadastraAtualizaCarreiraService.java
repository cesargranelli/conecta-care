package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraService {
    CadastraAtualizaCarreiraResponse salvar(CarreiraRequest request);
}
