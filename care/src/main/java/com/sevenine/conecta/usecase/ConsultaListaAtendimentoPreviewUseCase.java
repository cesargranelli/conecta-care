package com.sevenine.conecta.usecase;

import com.sevenine.conecta.services.data.request.atendimento.AtendimentoPreviewPara;
import com.sevenine.conecta.services.data.response.AtendimentoPreviewResponse;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public interface ConsultaListaAtendimentoPreviewUseCase {
    List<AtendimentoPreviewResponse> consultar(String cpfProfissional, String cpfPaciente, String areaAtendimentoId, 
            String statusAtendimentoId, String homeCareId, LocalDate periodoDe,  LocalDate periodoAte);
    
    File consultarFile(AtendimentoPreviewPara gerarPara, String cpfProfissional, String cpfPaciente, String areaAtendimentoId, 
            String statusAtendimentoId, String homeCareId, LocalDate periodoDe,  LocalDate periodoAte);            
    
}
