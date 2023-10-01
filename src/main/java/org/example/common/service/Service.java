package org.example.common.service;

import java.util.List;

public interface Service<ENTITY, ID>{
    ENTITY findById(ID id);
    List<ENTITY> getAll();
    void delete(ID id);
    ENTITY add(ENTITY entity);
}
