#include<iostream>
#include<stdexcept>
#include<vector>
#include<string>
#include"employee.cpp"
using namespace std;

Employee& findEmp(vector<Employee> &Emp , int eid){
	vector<Employee>::iterator it = Emp.begin();
	for(it;it!=Emp.end();it++){
		if(eid == it->GetEid())
		{
			return *it; 
		}
	}

	throw runtime_error("Employee not Found");
}

void DeleteEmp(vector<Employee> &Emp , int eid){
	vector<Employee>::iterator it = Emp.begin();
	for(it;it!=Emp.end();it++){
		if(eid == it->GetEid())
		{
			Emp.erase(it); 
			cout<<"Employe Deleted Succesfully\n";
			return;
		}
	}
	cout<<"Employee not found\n";
	throw runtime_error("Employee not Found");
}

int main()
{
		vector<Employee> emp;

	 	int choice = 0;
	 	int eid = 0;
		string name = "";
		string address = "";
		long salary = 0;
	
	do{
		cout<<"EMPLOYEE DETAILS"<<endl;
		cout<<"Choose the opt"<<endl;
		cout<<"1 for adding employee details"<<endl;
		cout<<"2 for Displaying all employees"<<endl;
		cout<<"3 for Searching an employee"<<endl;
		cout<<"4 for Deleting Employee"<<endl;
		cout<<"5 to exit menu"<<endl;
		cout<<"Enter your choice: ";
		cin>>choice;
		switch(choice){
			case 1:{
						cout<<"Enter Employee Details"<<endl;
						cout<<"Enter Eid: ";
						cin>>eid;
						cout<<"Enter name: ";
						cin>>name;
						cout<<"Enter address: ";
						cin>>address;
						cout<<"Enter salary: ";
						cin>>salary;
						emp.push_back(Employee(eid,name,address,salary));
						cout<<"-------------------------------------\n";
						break;
			       }
			case 2:{
					   cout<<" EID\t NAME\t ADDRESS\t SALARY\n";
					//    vector<Employee>::iterator it = emp.begin();
				    //    for(it;it!=emp.end();it++)
				    //    {
					//        it->Display();
				    //    }
					//    for(auto it = emp.begin(); it!=emp.end();it++){
					// 	 it->Display();
					//    }
					   for(Employee &empl: emp)
					   {
						empl.Display();
					   }
					   cout<<"-------------------------------------\n";
				       break;
			       }
			case 3:{	
						cout<<"Enter Employee ID: ";
						cin>>eid;
						
						cout<<" EID\t NAME\t ADDRESS\t SALARY\n";
						try{
							Employee FoundEmp = findEmp(emp,eid);
							FoundEmp.Display();
						}catch(runtime_error e){
							e.what();
						}
						cout<<"-------------------------------------\n";
						break;

					}
			case 4:{	
						cout<<"Enter Employee ID: ";
						cin>>eid;
						try{
							DeleteEmp(emp,eid);
						}catch(runtime_error e){
							e.what();
						}
						cout<<"-------------------------------------\n";
						break;
					}
			case 5:{	
						cout<<"-----------------END--------------------\n";
						cout<<"Exiting...";
						break;
					}
			defalut:{

						cout<<"yed zavya";
					}
				
				}
	
		}while(choice!=5);
}
