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
		void Accept();
		void Display() const;
		void CalcSalary();
};

