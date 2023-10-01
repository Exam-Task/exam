package org.example.common.repository;

import java.util.List;

public interface Repository<ID, ENTITY> {
    ENTITY findById(ID id);
    List<ENTITY> getAll();
    void delete(ID id);
    ENTITY add(ENTITY entity);

}
