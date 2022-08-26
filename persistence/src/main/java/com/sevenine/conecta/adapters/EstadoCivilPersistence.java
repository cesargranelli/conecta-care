package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.EstadoCivil;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.EstadoCivilRepository;
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
