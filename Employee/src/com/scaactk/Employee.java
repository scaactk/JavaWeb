package com.scaactk;

public class Employee {
    private int ID;
    private String FirstName;
    private String LastName;
    private String Department;

    public Employee(int ID, String firstName, String lastName, String department) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
        Department = department;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
