package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.EstadoCivil;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilPersistence implements DominioPersistence<Object, List<EstadoCivil>> {

    @Autowired
    private final EstadoCivilRepository repository;

    public EstadoCivilPersistence(EstadoCivilRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoCivil> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toEstadoCivil(repository.findAll());
    }

}
