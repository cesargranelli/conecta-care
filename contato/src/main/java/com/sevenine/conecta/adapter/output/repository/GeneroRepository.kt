package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.GeneroEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GeneroRepository : JpaRepository<GeneroEntity, Long>
