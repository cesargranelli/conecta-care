package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Parentesco;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.ParentescoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentescoPersistence implements DominioPersistence<Object, List<Parentesco>> {

    @Autowired
    private final ParentescoRepository repository;

    public ParentescoPersistence(ParentescoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Parentesco> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toParentesco(repository.findAll());
    }

}
