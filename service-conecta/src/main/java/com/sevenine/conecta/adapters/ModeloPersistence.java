package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Modelo;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloPersistence implements DominioPersistence<Object, List<Modelo>> {

    @Autowired
    private final ModeloRepository repository;

    public ModeloPersistence(ModeloRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Modelo> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toModelo(repository.findAll());
    }

}
