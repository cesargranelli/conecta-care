package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.TipoEmpresa;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.TipoEmpresaRepository;
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
