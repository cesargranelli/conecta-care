package com.sevenine.conecta.domain.ports.persistences;

public interface DominioPersistence<P, T> {
    T execute(P... objects);
}
