package com.kiroule.example.springjpaunitils.persistence;

import java.io.Serializable;

/**
 * @author Igor Baiborodine
 */
public interface BaseDao<T, PK extends Serializable> {
    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
}