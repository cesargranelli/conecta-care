package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.AreaAtendimento;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.AreaAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaAtendimentoPersistence implements DominioPersistence<Object, List<AreaAtendimento>> {

    @Autowired
    private final AreaAtendimentoRepository repository;

    public AreaAtendimentoPersistence(AreaAtendimentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AreaAtendimento> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toAreaAtendimento(repository.findAll());
    }

}
