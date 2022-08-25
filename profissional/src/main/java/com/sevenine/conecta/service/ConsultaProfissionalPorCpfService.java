package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.controllers.data.response.ProfissionalResponse;

import java.util.List;

public interface ConsultaProfissionalPorCpfService {
    ProfissionalResponse consultar(String numeroCpf);
}
