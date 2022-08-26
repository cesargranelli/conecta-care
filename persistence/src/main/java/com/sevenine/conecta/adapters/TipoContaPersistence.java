package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.TipoConta;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContaPersistence implements DominioPersistence<Object, List<TipoConta>> {

    @Autowired
    private final TipoContaRepository repository;

    public TipoContaPersistence(TipoContaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoConta> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toTipoConta(repository.findAll());
    }

}
