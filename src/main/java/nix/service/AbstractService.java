package nix.service;


import nix.data.AbstractData;

import java.util.List;

public interface AbstractService<T extends AbstractData<T>> {

    void saveOrUpdate(T t);
    T findById(String id);
    List<T> findAll();
    void remove(String id);
}
