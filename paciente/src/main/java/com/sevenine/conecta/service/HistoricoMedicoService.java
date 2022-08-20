package com.sevenine.conecta.service;

import com.sevenine.conecta.http.resource.HistoricoMedicoResource;

public interface HistoricoMedicoService {

    HistoricoMedicoResource create(HistoricoMedicoResource resource);

    HistoricoMedicoResource find(Long id);

    HistoricoMedicoResource edit(HistoricoMedicoResource resource);

}
