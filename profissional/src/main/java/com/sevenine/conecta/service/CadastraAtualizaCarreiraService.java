package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.CarreiraRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaCarreiraResponse;

public interface CadastraAtualizaCarreiraService {
    CadastraAtualizaCarreiraResponse salvar(CarreiraRequest request);
}
