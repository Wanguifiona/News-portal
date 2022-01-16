package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void user_instantiatesCorrectly_true() {
        User user = new User("George");
        assertTrue(user instanceof User);
    }

    @Test
    public void name_instantiatesWith_Name_true() {
        User user = new User("George");
        assertEquals("George", user.getName());
    }

    @Test
    public void name_createUser() {
        User user = new User("George");
        user.createUser("Joe");
        assertEquals("Joe", user.getName());
    }

    @Test
    public void user_namesAreEqual_true() {
        User firstuser = new User("George");
        User seconduser = new User("George");
        assertEquals(true, firstuser.equals(seconduser));
    }

    // HELPERS
    public User createUser1(){
        return new User("George");
    }
}