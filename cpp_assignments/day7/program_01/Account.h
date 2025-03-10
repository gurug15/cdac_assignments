#include<iostream>
#include<string>
using namespace std;



class Account{
 	private:
		static int cnt;
		int accNo=1000;
		string name;
		double balance;
	public:
		Account();
		Account(string,double);
		void Accept();
		void Display();
		int SetDepositMoney(int);
		int SetWithDrawMoney(int);
		int GetAccNo();

};


