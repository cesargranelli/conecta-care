package com.sevenine.conecta.adapter.output.repository;

import com.sevenine.conecta.adapter.output.entity.BancoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BancoRepository : JpaRepository<BancoEntity, Long>
