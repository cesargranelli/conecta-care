package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Pais;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisPersistence implements DominioPersistence<Object, List<Pais>> {

    @Autowired
    private final PaisRepository repository;

    public PaisPersistence(PaisRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pais> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toPais(repository.findAll());
    }

}
