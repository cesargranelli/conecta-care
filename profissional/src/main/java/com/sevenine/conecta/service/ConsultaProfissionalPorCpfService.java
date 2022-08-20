package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.controller.data.response.ProfissionalResponse;

import java.util.List;

public interface ConsultaProfissionalPorCpfService {
    ProfissionalResponse consultar(String numeroCpf);
}
