package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Department;
import models.News;
import models.User;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Sql2oDepartmentDaoTest {
    private Sql2oDepartmentDao departmentDao;
    private Sql2oNewsDao newsDao;
    private Connection conn;


    @Before
    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        newsDao = new Sql2oNewsDao(DB.sql2o);
        conn = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
//    @After
//    public void tearDown() throws Exception {
//        System.out.println("clearing database");
//        departmentDao.clearAll();
//        newsDao.clearAll();
//    }
//
//    @AfterClass
//    public static void shutDown() throws Exception{
//        conn.close();
//        System.out.println("connection closed");
//    }
@Test
public void getAll() throws Exception {
    Department department = setupDepartment();
    Department department1 = setupDepartment();
    assertEquals(2, departmentDao.getAll().size());
}

    @Test
    public void deleteById() throws Exception {
        Department testDepartment = setupDepartment();
        Department otherDepartment = setupDepartment();
        assertEquals(2, departmentDao.getAll().size());
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupDepartment();
        Department otherDepartment = setupDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }
    @Test
    public void getAllNewsForADepartmentReturnsNewsCorrectly() throws Exception {
        News news  = new News("The eruption");
        newsDao.add(news);

        News otherNews  = new News("Nairobi rush hour");
        newsDao.add(otherNews);

        Department department = setupDepartment();
        departmentDao.add(department);
        departmentDao.addDepartmentToNews(department,news);
        departmentDao.addDepartmentToNews(department,otherNews);

        News[] testNews = {news, otherNews};
        List<News> test2News = departmentDao.getAllNewsForADepartment(department.getId());
        for (News n:test2News
        ) {

            System.out.println("from dao "+n.getPost());

        }
        assertEquals(2,departmentDao.getAllNewsForADepartment(department.getId()).size());

        assertEquals(Arrays.asList(testNews), departmentDao.getAllNewsForADepartment(department.getId()));
    }

    //helpers
    public Department setupDepartment(){
        Department department =  new Department("HR",10,"Managing employees productivity");
        departmentDao.add(department);
        return department;
    }

    public News setupNews(){
        News news =  new News("Volcanic eruption");
        newsDao.add(news);
        return news;
    }


}
