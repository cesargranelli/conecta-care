package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Estado;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPersistence implements DominioPersistence<Object, List<Estado>> {

    @Autowired
    private final EstadoRepository repository;

    public EstadoPersistence(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estado> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toEstado(repository.findAll());
    }

}
