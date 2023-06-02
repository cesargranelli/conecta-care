package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.TipoEmpresa;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.TipoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEmpresaPersistence implements DominioPersistence<Object, List<TipoEmpresa>> {

    @Autowired
    private final TipoEmpresaRepository repository;

    public TipoEmpresaPersistence(TipoEmpresaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoEmpresa> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toTipoEmpresa(repository.findAll());
    }

}
