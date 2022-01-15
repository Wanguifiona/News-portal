package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {
    @Test
    public void department_instantiatesCorrectly_true() {
        Department department = new Department("HR", 10, "maximizing employee productivity");
        assertEquals(true, department instanceof Department);
    }

    @Test
    public void getName_InstantiatesWithName_name() {
        Department department = new Department("HR", 10, "maximizing employee productivity");
        assertEquals("HR", department.getName());
    }
    @Test
    public void getallEmployees_InstantiatesWithEmployees_employees() {
        Department department = new Department("HR", 10, "maximizing employee productivity");
        assertEquals(10, department.getAllEmployees());
    }
    @Test
    public void getDescription_InstantiatesWithDescription_description() {
        Department department = new Department("HR", 10, "maximizing employee productivity");
        assertEquals("maximizing employee productivity", department.getDescription());
    }

    @Test
    public void setName() {
        Department testDepartment = new Department ("HR", 10, "maximizing employee productivity");;
        testDepartment.setName("IT");
        assertNotEquals("HR", testDepartment.getName());
    }
    @Test
    public void setDescription() {
        Department testDepartment = new Department ("HR", 10, "maximizing employee productivity");;
        testDepartment.setDescription("software build");
        assertNotEquals("maximizing employee productivity", testDepartment.getDescription());
    }
   @Test
    public void setAllEmployees() {
        Department testDepartment = new Department ("HR", 10, "maximizing employee productivity");;
        testDepartment.setAllEmployees(12);
        assertNotEquals(10, testDepartment.getAllEmployees());
    }


















    // helper
    public Department setupDepartment(){
        return new Department("HR", 10, "maximizing employee productivity");
    }
}