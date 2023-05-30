package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Instrucao;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.InstrucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrucaoPersistence implements DominioPersistence<Object, List<Instrucao>> {

    @Autowired
    private final InstrucaoRepository repository;

    public InstrucaoPersistence(InstrucaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Instrucao> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toInstrucao(repository.findAll());
    }

}
