package dao;

import models.Department;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;
    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (post) VALUES (:post)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }
    @Override
    public News findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }
    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id = :id"; //raw sql
//        String deleteJoin = "DELETE from restaurants_foodtypes WHERE restaurantid = :restaurantId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
//            con.createQuery(deleteJoin)
//                    .addParameter("restaurantId", id)
//                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
        @Override
        public void addNewsToDepartment(News news, Department department){
            String sql = "INSERT INTO departments_news (newsid, departmentid) VALUES (:newsid, :departmentid)";
            try (Connection con = sql2o.open()) {
                con.createQuery(sql)
                        .addParameter("departmentid", department.getId())
                        .addParameter("newsid", news.getId())
                        .executeUpdate();
            } catch (Sql2oException ex){
                System.out.println(ex);
            }
        }

        @Override
        public List<Department> getAllDepartmentsForANews(int id){
            List<Department> departments = new ArrayList(); //empty list
            String joinQuery = "SELECT departmentid FROM departments_news WHERE newsid = :newsid";

            try (Connection con = sql2o.open()) {
                List<Integer> departmentIds = con.createQuery(joinQuery)
                        .addParameter("newsId", id)
                        .executeAndFetch(Integer.class);
                for (Integer departmentId : departmentIds){
                    String departmentQuery = "SELECT * FROM departments WHERE id = :departmentid";
                    departments.add(
                            con.createQuery(departmentQuery)
                                    .addParameter("departmentId", departmentId)
                                    .executeAndFetchFirst(Department.class));
                }
            } catch (Sql2oException ex){
                System.out.println(ex);
            }
            return departments;
        }
    }



