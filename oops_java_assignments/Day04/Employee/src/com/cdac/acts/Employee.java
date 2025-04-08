package com.cdac.acts;

public class Employee {
	public int empId;
    String name;
    public int sal;

    public Employee(int empId, String name, int sal) {
        this.empId = empId;
        this.name = name;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "EMP ID: " + empId + ", EMPLOYEE NAME: " + name + ", SALARY: " + sal;
    }
}
