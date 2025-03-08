#include<iostream>
#include<string>
using namespace std;

class Employee {
	private:
		int empNo;
		string name;
		long salary;
		string department;

	public:
		void Accept(){
			cout<<"Enter EmpNO, name,salary, department:"<<endl;
			cin>>this->empNo;
			cin>>this->name;
			cin>>this->salary;
			cin>>this->department;
		}

		void Display(){
			cout<<this->empNo<<" ";
			cout<<this->name<<" ";
			cout<<this->salary<<" ";
			cout<<this->department<<endl;
		}

		long getSalary(){
			return this->salary;
		}

		int getEmployeeId(){
			return this->empNo;
		}
		
};

void swap(Employee * a, Employee * b){
	Employee temp = *a;
	*a = *b;
	*b = temp;
}




void sortSalary(Employee One[],int no){
          
	for(int i=0;i<no;i++){
		for(int j=0;j<no-1-i;j++){
			if(One[j].getSalary()>One[j+1].getSalary()){
 				swap(One[j],One[j+1]);
			}
		}
	}
	
}

void sortEmployee(Employee One[],int no){
          
	for(int i=0;i<no;i++){
		for(int j=0;j<no-1-i;j++){
			if(One[j].getEmployeeId()>One[j+1].getEmployeeId()){
 				swap(One[j],One[j+1]);
			}
		}
	}
}


void sortName(Employee One[],int no){
          
	for(int i=0;i<no;i++){
		for(int j=0;j<no-1-i;j++){
			if(One[j].getEmployeeId()>One[j+1].getEmployeeId()){
 				swap(One[j],One[j+1]);
			}
		}
	}
}


void PrintArray(Employee One[],int n){
     
     for(int i=0;i<n;i++){
	     One[i].Display();
     }

}

int main(){
     int no;
     cout<<"Enter no of employee: ";
     cin>>no;
     //Employee *One = new Employee[no];
     Employee One[no];
     //accepting Data:
     for(int i=0;i<no;i++){
	     One[i].Accept();
     }
 	sortSalary(One,no);
        PrintArray(One,no);
	sortEmployee(One,no);
	cout<<"Printing sorted Employee Id:"<<endl;
	PrintArray(One,no);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	for(int i=0;i<no;i++){
		for(int j=0;j<no-1-i;j++){
			if(One[j].getSalary()>One[j+1].getSalary()){
 				Employee temp = One[j];
				One[j] = One[j+1];
				One[j+1] = temp;
			}
		}
	}
	*/



     return 0;
}
	
                     
