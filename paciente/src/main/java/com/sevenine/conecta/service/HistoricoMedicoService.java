package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.resource.HistoricoMedicoResource;

public interface HistoricoMedicoService {

    HistoricoMedicoResource create(HistoricoMedicoResource resource);

    HistoricoMedicoResource find(Long id);

    HistoricoMedicoResource edit(HistoricoMedicoResource resource);

}
