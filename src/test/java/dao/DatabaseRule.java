package dao;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource{

    @Override
    public void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal_test", "fiona", "Man");
    }

    @Override
    public void after() {
        try (Connection conn = DB.sql2o.open()) {
            String deleteUserQuery = "DELETE FROM users";
            String deleteDepartmentsQuery = "DELETE FROM departments";
            String deleteNewsQuery = "DELETE FROM news";
            conn.createQuery(deleteUserQuery).executeUpdate();
            conn.createQuery(deleteDepartmentsQuery).executeUpdate();
            conn.createQuery(deleteNewsQuery).executeUpdate();
        }


    }
}