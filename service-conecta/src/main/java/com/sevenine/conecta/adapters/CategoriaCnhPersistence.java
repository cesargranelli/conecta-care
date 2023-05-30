package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.CategoriaCnh;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.CategoriaCnhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaCnhPersistence implements DominioPersistence<Object, List<CategoriaCnh>> {

    @Autowired
    private final CategoriaCnhRepository repository;

    public CategoriaCnhPersistence(CategoriaCnhRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaCnh> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toCategoriaCnh(repository.findAll());
    }

}
