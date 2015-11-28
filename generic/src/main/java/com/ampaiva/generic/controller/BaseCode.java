package com.ampaiva.generic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseCode {

    static final String SELECT_ID_NAME_FROM_PROJECTS = "SELECT ID, NAME FROM PROJECTS";
    EntityManagerFactory emFactory;
    EntityManager entityManager;
    final String persistenceUnitName;
    protected final String query = SELECT_ID_NAME_FROM_PROJECTS;

    public BaseCode(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    protected Statement begin() throws SQLException {
        emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Connection con = entityManager.unwrap(java.sql.Connection.class);
        Statement stmt = con.createStatement();
        return stmt;
    }

    protected void commit() {
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManager = null;
    }

}
