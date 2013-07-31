package com.kiroule.example.springjpaunitils.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Igor Baiborodine
 */
public abstract class AbstractJpaDao<T, ID extends Serializable>
        implements BaseDao<T, ID> {

    protected Class<T> clazz;

    @PersistenceContext(unitName="spring-jpa-unitils-pu")
    protected EntityManager em;

    public AbstractJpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T read(ID id) {
        return em.find(clazz, id);
    }

    @Override
    public T update(T t) {
        return em.merge(t);
    }

    @Override
    public void delete(T t) {
        t = em.merge(t);
        em.remove(t);
    }
}
