package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ProfissionalCompletoResponse;
import com.sevenine.conecta.controller.data.response.ProfissionalCpfResponse;

import java.util.List;

public interface ConsultaProfissionalCompletoUseCase {
    ProfissionalCompletoResponse executar(Long cpf);
}
