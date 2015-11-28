package com.ampaiva.generic.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ampaiva.generic.model.Project;

public class CodeCloneType4Version2 {
    private static final String SELECT_ID_NAME_FROM_PROJECTS = "SELECT ID, NAME FROM PROJECTS";
    private EntityManagerFactory emFactory;
    EntityManager entityManager;
    private final String persistenceUnitName;

    public CodeCloneType4Version2(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public List<Project> getProjects3() throws SQLException {
        emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Connection con = entityManager.unwrap(java.sql.Connection.class);
        String query = SELECT_ID_NAME_FROM_PROJECTS;
        Statement stmt = con.createStatement();
        List<Project> results = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            boolean hasElements;
            for (hasElements = rs.first(); hasElements; hasElements = rs.next()) {
                Project project = new Project(rs.getInt(1), rs.getString(2));
                results.add(project);
            }
        } finally {
            stmt.close();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManager = null;
        return results;
    }
}
