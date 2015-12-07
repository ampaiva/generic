package target;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ampaiva.generic.model.Project;

public class CodeCloneType1 extends BaseCode {

    public CodeCloneType1(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    public List<Project> getProjects1() throws SQLException {
        Statement stmt = begin();
        List<Project> results = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                results.add(new Project(rs.getInt(1), rs.getString(2)));
            }
        } finally {
            stmt.close();
        }
        commit();
        return results;
    }
}
