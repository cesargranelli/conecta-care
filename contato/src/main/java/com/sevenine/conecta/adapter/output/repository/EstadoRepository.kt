package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface EstadoRepository : JpaRepository<EstadoEntity, Long>
