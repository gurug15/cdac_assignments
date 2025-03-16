#include<iostream>
#include<string>
using namespace std;


class Employee
{
 	private:
		int eid;
		string name;
		string address;
		long salary;
	public:
		Employee(): eid(0),name(""),address(""),salary(0)
		{
		}
		Employee(int eid,string name,string address,long salary): eid(eid),name(name),address(address),salary(salary)
		{
		}
		void Accept()
		{
			cout<<"Enter Employee Details"<<endl;
			cout<<"Enter Eid: ";
			cin>>eid;
			cout<<"Enter name: ";
			cin>>name;
			cout<<"Enter address: ";
			cin>>address;
			cout<<"Enter salary: ";
			cin>>salary;
		}
		void Display()
		{
			cout<<" ";
			cout<<eid;
			cout<<"\t ";
			cout<<name;
			cout<<"\t ";
			cout<<address;
			cout<<"\t ";
			cout<<salary<<endl;
		}
		int GetEid(){
			return this->eid;
		}

};

