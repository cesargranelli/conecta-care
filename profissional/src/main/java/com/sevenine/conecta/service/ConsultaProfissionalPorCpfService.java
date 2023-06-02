package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ConsultaProfissionalPorCpfService {
    ProfissionalResponse consultar(String numeroCpf);
}
