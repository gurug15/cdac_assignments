#include<iostream>
#include<string>
using namespace std;

class Employee
{
	private:
		string eid;
		string name;
		double salary;
	public:
		Employee();
		Employee(string eid,string name,double salary);
		virtual void Accept();
		virtual void Display() const;
		double GetSalary();
		virtual void CalcSalary()=0;
};

class PermenentEmp: public Employee
{
	private:
		double ta, hra;
	public:
		PermenentEmp();
		PermenentEmp(double ta,double hra,string eid,string name, double salary);
		void Accept();
		void Display() const;
		void CalcSalary();
};

class ContractEmp: public Employee
{
	private:
		int hr;
		double rate;
	public:
		ContractEmp();
		ContractEmp(int hr,double rate,string eid,string name, double salary);
		void Accept();
		void Display() const;
		void CalcSalary();
};

