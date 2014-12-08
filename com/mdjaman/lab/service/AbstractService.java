/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdjaman.lab.service;

/**
 *
 * @author Marcel Djaman <marceldjaman@gmail.com>
 */
import java.util.List;

import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService<T> {

    private Class<T> type;
    private EntityManager em;
    
    private static final Logger log = LoggerFactory.getLogger("");

    protected EntityManager getEntityManager() {
        return em;
    }

    public T find(Integer id) {
        return em.find(type, id);
    }

    public void delete(T obj) {
        em.remove(em.contains(obj) ? obj : em.merge(obj));
        em.flush();
    }
    
    public T save(T obj) {
        em.persist(obj);
        em.flush();
        return obj;
    }

    public T saveOrUpdate(T obj) {
        if (obj.getId() == null) {
            em.persist(obj);
        } else {
            em.merge(obj);
        }
        em.flush();
        return obj;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return em.createQuery("from " + type.getSimpleName()).getResultList();
    }

    public boolean isExist(Long id) {
        return true;
    }
    
    public Long getCount() {
        return (Long) em.createQuery(
                "select count(*) from " + type.getSimpleName())
                .getSingleResult();
    }

}
