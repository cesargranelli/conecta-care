package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Genero;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroPersistence implements DominioPersistence<Object, List<Genero>> {

    @Autowired
    private final GeneroRepository repository;

    public GeneroPersistence(GeneroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Genero> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toGenero(repository.findAll());
    }

}
