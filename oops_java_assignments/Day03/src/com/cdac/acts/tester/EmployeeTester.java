package com.cdac.acts.tester;
import java.util.Scanner;
import com.cdac.acts.Employee;

public class EmployeeTester {
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of Employees: ");
        int size = in.nextInt();
        Employee []emps; 
        emps = new Employee[size];
        
        for(int i=0;i<emps.length;i++){
            System.out.print("Enter Name :");
            String name = in.next();
            System.out.print("Enter Salary:");
            double salary = in.nextDouble();
            emps[i] = new Employee(name,salary);
        }

        for(int i=0;i<size;i++){
            emps[i].printData();
        }
        in.close();
    }
}