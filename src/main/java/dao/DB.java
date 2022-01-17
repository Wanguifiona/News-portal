package dao;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal", "fiona", "Man");

//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-216-113-109.compute-1.amazonaws.com:5432/d7hqiacsnied5j?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "bgwqbtgpaaszcr", "e55b1fc7c6e8dba5d22fd3036bb6d22857d714694c997e8f9059ac8e54b162f3");
//

}