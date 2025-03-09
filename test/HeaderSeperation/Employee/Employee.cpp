#include<iostream>
#include<string>
#include"Employee.h"
using namespace std;

void Employee::Accept(){
        cout<<"Enter EmpNo"<<endl;
        cin>>this->empNo;
        cout<<"Enter  name"<<endl;
        cin>>this->name;
        cout<<"Enter salary"<<endl;
        cin>>this->salary;
        cout<<"Enter department"<<endl;
        cin>>this->department;
        cout<<"Done"<<endl;
}

void Employee::Display(){
        cout<<this->empNo<<" \t";
        cout<<this->name<<" \t";
        cout<<this->salary<<" \t";
        cout<<this->department<<endl;
}

long Employee::getSalary(){
    return this->salary;
}

int Employee::getEmployeeId(){
    return this->empNo;
}