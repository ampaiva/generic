package com.ampaiva.generic.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.Test;

import com.ampaiva.generic.model.Project;

public class CodeCloneTest {

    private static final String PU_NAME = "genericTEST";
    private static final String PROJECT_LOCATION = "/somewhere/TestProject.zip";
    private static final String PROJECT_NAME = "TestProject";

    @Test
    public void testGetProjects1() throws SQLException {
        DataManager dataManager = new DataManager(PU_NAME);
        dataManager.open();
        Project project1 = new Project();
        project1.setName(PROJECT_NAME);
        project1.setLocation(PROJECT_LOCATION);
        Project project2 = new Project();
        project2.setName(PROJECT_NAME + "2");
        project2.setLocation(PROJECT_LOCATION);
        dataManager.persist(project1);
        dataManager.persist(project2);
        dataManager.commit();

        int id1 = project1.getId();
        assertTrue(id1 > 0);
        int id2 = project2.getId();
        assertTrue(id2 > 0);

        OriginalCode codeClone = new OriginalCode(PU_NAME);
        Collection<Project> projects = codeClone.getProjects1();
        assertNotNull(projects);
        assertEquals(2, projects.size());

        dataManager.begin();
        dataManager.removeAll(Project.class);
        dataManager.commit();
        Collection<Project> projects2 = dataManager.findAll(Project.class);
        assertNotNull(projects2);
        assertEquals(0, projects2.size());
        dataManager.close();
    }

    @Test
    public void testGetProjects2() throws SQLException {
        DataManager dataManager = new DataManager(PU_NAME);
        dataManager.open();
        com.ampaiva.generic.model.Project project1 = new Project();
        project1.setName(PROJECT_NAME);
        project1.setLocation(PROJECT_LOCATION);
        Project project2 = new com.ampaiva.generic.model.Project();
        project2.setName(PROJECT_NAME + "2");
        project2.setLocation(PROJECT_LOCATION);
        dataManager.persist(project1);
        dataManager.persist(project2);
        dataManager.commit();

        int id1 = project1.getId();
        assertTrue(id1 > 0);
        int id2 = project2.getId();
        assertTrue(id2 > 0);

        CodeCloneType4 codeClone = new CodeCloneType4(PU_NAME);
        Collection<Project> projects = codeClone.getProjects2();
        assertNotNull(projects);
        assertEquals(2, projects.size());

        dataManager.begin();
        dataManager.removeAll(Project.class);
        dataManager.commit();
        Collection<Project> projects2 = dataManager.findAll(Project.class);
        assertNotNull(projects2);
        assertEquals(0, projects2.size());
        dataManager.close();
    }

    @Test
    public void testGetProjects3() throws SQLException {
        DataManager dataManager = new DataManager(PU_NAME);
        dataManager.open();
        Project project1 = new Project();
        project1.setName(PROJECT_NAME);
        project1.setLocation(PROJECT_LOCATION);
        Project project2 = new Project();
        project2.setName(PROJECT_NAME + "2");
        project2.setLocation(PROJECT_LOCATION);
        dataManager.persist(project1);
        dataManager.persist(project2);
        dataManager.commit();

        int id1 = project1.getId();
        assertTrue(id1 > 0);
        int id2 = project2.getId();
        assertTrue(id2 > 0);

        CodeCloneType4Version2 codeClone = new CodeCloneType4Version2(PU_NAME);
        Collection<Project> projects = codeClone.getProjects3();
        assertNotNull(projects);
        assertEquals(2, projects.size());

        dataManager.begin();
        dataManager.removeAll(Project.class);
        dataManager.commit();
        Collection<Project> projects2 = dataManager.findAll(Project.class);
        assertNotNull(projects2);
        assertEquals(0, projects2.size());
        dataManager.close();
    }
}
