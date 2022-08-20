package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TratamentoRepository extends JpaRepository<Tratamento, Long> {
    Optional<List<Tratamento>> findByPacienteIdAndHomeCareId(Long pacienteId, Long homeCareId);

    Optional<List<Tratamento>> findDistinctByHomeCareIdAndAtendimentosDataBetween(Long homeCareId, LocalDate dataInicio, LocalDate dataFim);

    Optional<Tratamento> findFirst1ByPacienteIdAndHomeCareIdAndObservacaoNullAndSituacoesStatusDescricaoOrderBySituacoesDataHoraDesc(Long pacienteId, Long homeCareId, String aberto);

    Optional<List<Tratamento>> findByHomeCareIdAndObservacaoNullAndSituacoesStatusDescricao(Long homeCareId, String aberto);
}
