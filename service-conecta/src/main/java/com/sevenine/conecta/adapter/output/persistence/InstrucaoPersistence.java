package com.sevenine.conecta.adapter.output.persistence;

import com.sevenine.conecta.domain.model.Instrucao;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.adapter.output.repository.InstrucaoRepository;
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
