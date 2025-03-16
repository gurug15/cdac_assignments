#include<iostream>
#include<string>
#include<stdexcept>
#include"account.cpp"
using namespace std;




int main()
{
	Account acc(10001,"Guru",1000);
	acc.Display();
	try{
	acc.withdraw(200);
	}
	catch(runtime_error e)
	{
		cout<<e.what()<<endl;
	}
	try{
	acc.deposit(2000000);
	}
	catch(runtime_error e)
	{
		cout<<e.what()<<endl;
	}
	acc.Display();



	return 0;
}


