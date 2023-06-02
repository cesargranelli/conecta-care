package com.sevenine.conecta.domain.port.persistence;

public interface DominioPersistence<P, T> {
    T execute(P... objects);
}
