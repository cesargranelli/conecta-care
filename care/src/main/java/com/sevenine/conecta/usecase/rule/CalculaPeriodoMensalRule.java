package com.sevenine.conecta.usecase.rule;

import java.time.LocalDate;
import java.util.Map;

public interface CalculaPeriodoMensalRule {
    Map<String, LocalDate> executar(LocalDate dataConsulta);
}
