package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Banco;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoPersistence implements DominioPersistence<Object, List<Banco>> {

    @Autowired
    private final BancoRepository repository;

    public BancoPersistence(BancoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Banco> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toBanco(repository.findAll());
    }

}
