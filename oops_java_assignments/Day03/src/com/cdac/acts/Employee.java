package com.cdac.acts;
public class Employee {
    private static long count = 250240001;
    private long empNo;
    private String name;
    private double salary;

    public Employee(){
        this.empNo = count++;
        this.name = "";
        this.salary = 0;
    } 

    public Employee(String name,double salary){
        this.empNo= count++;
        this.name = name;
        this.salary = salary;
    }

    public static long getBaseId(){
        return count;
    } 

    public void printData(){
        System.out.println("Employee [ "
        + "empNo = " + empNo
        + ", name = " + name
        + ", salary = " + salary + " ]"
        );
    } 
    //  public static void main(String [] args)
    // {
    //     Employee []emp = new Employee[5]; // in sense of cpp-- Employee emp is refrance to 5 element in heap which will refer to each object 
    //     System.out.println(emp.length);
    //     int n = 100;
    //     for(int i=0;i<emp.length;i++){
    //         emp[i] = new Employee("random"+i,n+=100000);
    //     }
    //     for(int i=0;i<emp.length;i++){
    //         emp[i].printData();
    //     }
        
    // }

}