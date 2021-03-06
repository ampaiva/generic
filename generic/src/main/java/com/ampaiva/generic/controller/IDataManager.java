package com.ampaiva.generic.controller;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

public interface IDataManager {

    void open();

    <G> void persist(G entity);

    <T> void refresh(T entity);

    <H> void removeAll(Class<H> clazz);

    void close();

    <U> Collection<U> findAll(Class<U> clazz);

    <U> List<U> getResultList(Class<U> clazz, String namedQuery, Object... params);

    <U> U getSingleResult(Class<U> clazz, String namedQuery, Object... params);

    EntityManager getEM();
}