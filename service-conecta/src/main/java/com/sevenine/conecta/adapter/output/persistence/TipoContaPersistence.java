package com.sevenine.conecta.adapter.output.persistence;

import com.sevenine.conecta.domain.model.TipoConta;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.adapter.output.repository.TipoContaRepository;
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
