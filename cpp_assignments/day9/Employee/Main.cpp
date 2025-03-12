#include<iostream>
#include"Employee.h"
using namespace std;


int main()
{
	// Employee *Emp[2];
	// Emp[0] = new PermenentEmp();
	// Emp[1] = new ContractEmp();

    //     for(int i =0;i<2;i++){
	// 	Emp[i]->Accept();
	// }
    //     for(int i =0;i<2;i++){
	// 	Emp[i]->Display();
	// 	Emp[i]->CalcSalary();
	// }


	// delete Emp[0],Emp[1];


	Employee *Emp = new PermenentEmp(100,100,"203","Guru",1000);
	Emp->Display();
	Emp->CalcSalary();

	return 0;

}
