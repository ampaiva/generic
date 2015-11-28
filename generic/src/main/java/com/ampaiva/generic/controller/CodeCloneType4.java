package com.ampaiva.generic.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ampaiva.generic.model.Project;

public class CodeCloneType4 extends BaseCode {

    public CodeCloneType4(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    public List<Project> getProjects2() throws SQLException {
        Statement stmt = begin();
        List<Project> list = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.first()) {
                return list;
            }
            do {
                list.add(new Project(rs.getInt(1), rs.getString(2)));
            } while (rs.next());
        } finally {
            stmt.close();
        }
        commit();
        return list;
    }
}
