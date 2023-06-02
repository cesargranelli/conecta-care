package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Genero;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.GeneroRepository;
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
