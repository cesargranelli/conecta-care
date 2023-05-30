package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Transporte;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportePersistence implements DominioPersistence<Object, List<Transporte>> {

    @Autowired
    private final TransporteRepository repository;

    public TransportePersistence(TransporteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transporte> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toTransporte(repository.findAll());
    }

}
