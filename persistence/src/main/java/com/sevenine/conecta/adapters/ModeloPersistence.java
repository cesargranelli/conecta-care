package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Modelo;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.ModeloRepository;
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
