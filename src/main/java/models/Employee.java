package models;

public class Employee {
    private String role;
    private String position;
    private String department;
    private int departmentId;
    private int id;



    public Employee(String position, String role, String department){
        this.position = position;
        this.role = role;
        this.department = department;

    }
    public String getPosition(){
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
