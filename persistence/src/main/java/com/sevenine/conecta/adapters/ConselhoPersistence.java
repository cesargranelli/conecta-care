package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Conselho;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.ConselhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConselhoPersistence implements DominioPersistence<Object, List<Conselho>> {

    @Autowired
    private final ConselhoRepository repository;

    public ConselhoPersistence(ConselhoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Conselho> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toConselho(repository.findAll());
    }

}
