package com.sevenine.conecta.repository;

import com.sevenine.conecta.repository.data.TipoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa, Long> {
    TipoEmpresa findByDescricao(String tipoDocumento);
}
