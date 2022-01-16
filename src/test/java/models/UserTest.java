
package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameReturnsCorrectName() {
        User user = new User ("George","Intern","Junior developer",701);
        assertEquals("George", user.getName());
    }

    @Test
    public void getPositionReturnsCorrectPosition() {
        User user = new User ("George","Intern","Junior developer",701);
        assertEquals("Intern", user.getPosition());
    }

    @Test
    public void getRoleReturnsCorrectRole() {
        User user = new User ("George","Intern","Junior developer",701);
        assertEquals("Junior developer", user.getRole());
    }

    @Test
    public void getDepartmentReturnsCorrectDepartment() {
        User user = new User ("George","Intern","Junior developer",701);
        assertEquals(701, user.getDepartmentId());
    }

    @Test
    public void setNameSetsCorrectName() throws Exception {
        User user = new User ("George","Intern","Junior developer",701);
        user.setName("Saul");
        assertNotEquals("George",user.getName());
    }


    @Test
    public void setPositionSetsCorrectPosition() throws Exception {
        User user = new User ("George","Intern","Junior developer",701);
        user.setPosition("Manager");
        assertNotEquals("Intern",user.getPosition());
    }

    @Test
    public void setRoleSetsCorrectRole() throws Exception {
        User user = new User ("George","Intern","Junior developer",701);
        user.setRole("HR");
        assertNotEquals("Junior developer",user.getRole());
    }

    //helper
    public User setupUser(){
        return  new User("George","Intern","Junior developer",701);
    }

}