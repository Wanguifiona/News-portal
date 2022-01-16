package dao;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal_test", "fiona", "Man");



}