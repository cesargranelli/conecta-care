package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Transporte;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.TransporteRepository;
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
