package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.resource.HistoricoMedicoResource;

public interface HistoricoMedicoService {

    HistoricoMedicoResource create(HistoricoMedicoResource resource);

    HistoricoMedicoResource find(Long id);

    HistoricoMedicoResource edit(HistoricoMedicoResource resource);

}
