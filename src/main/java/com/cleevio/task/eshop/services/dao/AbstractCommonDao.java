package com.cleevio.task.eshop.services.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Map;

public abstract class AbstractCommonDao {
    protected EntityManager em;
    protected JPAQueryFactory queryFactory;

    @Autowired(required = false)
    public void setEm(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public void remove(Object entity) {
        em.remove(entity);
    }

    public <T> T merge(T entity) {
        return em.merge(entity);
    }

    public void persist(Object entity) {
        em.persist(entity);
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return em.find(entityClass, primaryKey);
    }
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockModeType) {
        return em.find(entityClass, primaryKey, lockModeType);
    }
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
        return em.find(entityClass, primaryKey, lockMode, properties);
    }

    public <T> T getReference(Class<T> entityClass, Object primaryKey) {
        return em.getReference(entityClass, primaryKey);
    }

    public void flush() {
        em.flush();
    }

    public void clear() {
        em.clear();
    }

    public void detach(Object entity) {
        em.detach(entity);
    }
}
