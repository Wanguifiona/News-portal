package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void employee_instantiatesCorrectly_true() {
        Employee employee = new Employee("Mike", "Junior","Junior developer", "IT");
        assertTrue(employee instanceof Employee);
    }

    @Test
    public void name_instantiatesWithName_name() {
        Employee employee = new Employee("Mike", "Junior","Junior developer", "IT");
        assertEquals("Mike", employee.getName());
    }

    @Test
    public void position_instantiatesWithPosition_position() {
        Employee employee = new Employee("Mike", "Junior","Junior developer", "IT");
        assertEquals("Junior", employee.getPosition());
    }

    @Test
    public void role_instantiatesWithRole_role() {
        Employee employee = new Employee("Mike", "Junior","Junior developer", "IT");
        assertEquals("Junior developer", employee.getRole());
    }

    @Test
    public void name_setsEmployeeName_department() {
        Employee employee = new Employee("Mike", "Junior","Junior developer", "IT");
        employee.setName("Saul");
        assertEquals("Saul", employee.getName());
    }

//    @Test
//    public void employee_nameAndPositionAreTheSame() {
//        Employee firstemployee = new Employee("Mike", "Junior","Junior developer", "IT");
//        Employee secondemployee = new Employee("Saul", "Senior","Senior developer", "IT");
//        assertEquals(true, firstemployee.equals(secondemployee));
//    }

    // HELPERS
    public Employee createEmployee1(){
        return new Employee("Mike", "Junior","Junior developer", "IT");
    }

    public Employee createEmployee2(){
        return new Employee("Saul", "Junior","Junior Developers", "IT");
    }
}