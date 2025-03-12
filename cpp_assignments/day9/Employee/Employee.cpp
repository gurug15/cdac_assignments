#include<iostream>
#include"Employee.h"
#include<string>
using namespace std;





Employee::Employee()//: eid(""), name(""), salary(0)
{
	this->eid = "";
	this->name = "";
	this->salary = 0;
}

Employee::Employee(string eid,string name,double salary)
{
	this->eid = eid;
	this->name = name;
	this->salary = salary;
}

void Employee::Accept()
{
	cout<<"Enter EmployeeId: ";
	cin>>this->eid;
	cout<<"Enter Name: ";
	cin>>this->name;
	cout<<"Enter Salary: ";
	cin>>this->salary;
}
void Employee::Display() const
{
	cout<<"EmployeeId: "<<this->eid<<endl;
	cout<<"Name: "<<this->name<<endl;
	cout<<"Salary: "<<this->salary<<endl;
}


double Employee::GetSalary()
{
	return this->salary;
}

PermenentEmp::PermenentEmp(): ta(0), hra(0)
{
}
PermenentEmp::PermenentEmp(double ta,double hra,string eid,string name, double salary):Employee(eid,name,salary)
{
	this->ta =ta;
	this->hra = hra;
}

void PermenentEmp::Accept()
{
	cout<<"Enter Permanant Employee"<<endl;
	Employee::Accept();
	cout<<"enter Travel Allowance: ";
	cin>>this->ta;
	cout<<"enter Home rent Allowance: ";
	cin>>this->hra;

}
void PermenentEmp::Display() const
{

	cout<<"Permanant Employee"<<endl;
	Employee::Display();
	cout<<"Travel Allowance: "<<this->ta<<endl;
	cout<<"Home rent Allowance: "<<this->hra<<endl;
}

void PermenentEmp::CalcSalary()
{
	cout<<"Salary of Permenant Employee is: ";
	double sal = Employee::GetSalary() + this->ta + this->hra;
       	cout<<sal<<endl;
}	

ContractEmp::ContractEmp(): hr(0), rate(0)
{
}
ContractEmp::ContractEmp(int hr,double rate,string eid,string name, double salary):Employee(eid,name,salary)
{
	this->hr =hr;
	this->rate = rate;
}

void ContractEmp::Accept()
{
	cout<<"Enter Contract Employee"<<endl;
	Employee::Accept();
	cout<<"enter Contract Hrs: ";
	cin>>this->hr;
	cout<<"enter Hourly rate: ";
	cin>>this->rate;

}
void ContractEmp::Display() const
{
	cout<<"Cotract Employee"<<endl;
	Employee::Display();
	cout<<"Contract Hours: "<<this->hr<<endl;
	cout<<"Contract Hourly rate: "<<this->rate<<endl;
}

void ContractEmp::CalcSalary()
{
	cout<<"Salary of Contract Employee is: ";
	double sal = Employee::GetSalary() + this->hr * this->rate;
       	cout<<sal<<endl;
}
