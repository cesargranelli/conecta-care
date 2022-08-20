package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    Optional<List<Atendimento>> findByHomeCareIdAndDataBetween(Long idHomeCare, LocalDate dataInicio, LocalDate dataFim);

    Optional<List<Atendimento>> findByProfissionalIdAndData(Long profissionalId, LocalDate data);

    Optional<List<Atendimento>> findByProfissionalIdAndDataBetween(Long profissionalId, LocalDate dataInicio, LocalDate dataFim);
    
    Optional<List<Atendimento>> findByPacienteId(Long pacienteId);
}
