package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.InstrucaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface InstrucaoRepository : JpaRepository<InstrucaoEntity, Long>
