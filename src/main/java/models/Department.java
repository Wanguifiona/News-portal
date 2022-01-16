package models;

import java.util.Objects;

public class Department {
    private String name;
    private int allEmployees;
    private String description;
    private int id;


    public Department(String name, int allEmployees, String description){
        this. name = name;
        this.allEmployees =allEmployees;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public int getAllEmployees(){
        return allEmployees;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAllEmployees(int allEmployees){
        this.allEmployees = allEmployees;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return id == that.id &&
                allEmployees == that.allEmployees &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, allEmployees, description, id);
    }
}
