#include<iostream>
#include<string>
#include<stdexcept>
using namespace std;


/*
class AccountException: public runtime_error
{
	string str;
	public:
	AccountExceptoin(string s)
	{
		str = s;
	}
	string what()
	{
		return str;
	}
}*/
// Account a(1,guru,1000);
// Account b();
// b.Accept();


class Account
{
	private:
		long accNo;
		string name;
		double balance;
	public:
		Account(): accNo(0), name(""), balance(0)
		{
		}
		Account(long accNo, string name,double balance): accNo(accNo), name(name), balance(balance)
		{
		}
		void Accept()
		{
			cout<<"Enter account details"<<endl;
			cout<<"Enter AccNo: ";
			cin>>this->accNo;
			cout<<"Enter Name: ";
			//cin.get();
			//getline(cin,name);
			cin>>this->name;
			cout<<"Enter Balance: ";
			cin>>this->balance;
		}
		void Display()
		{
			cout<<"account details"<<endl;
			cout<<"AccNo: ";
			cout<<this->accNo;
			cout<<"\nName: ";
			cout<<this->name;
			cout<<"\nBalance: ";
			cout<<this->balance<<endl;

		}
		void withdraw(int amount)
		{
			if(amount < 0)
			{
				throw runtime_error("invalid amount\n");
				//return;
			}

			if(balance < 1000 && amount > balance)
			{
				throw runtime_error("Insufficient Funds\n");
				return;
			}

			this->balance = this->balance - amount;
			cout<<amount<<"/- Debited from your account new balance: "<<balance<<"/-\n";
		}
		void deposit(int amount)
		{
			if(amount < 0)
			{
				throw runtime_error("invalid amount\n");
				return;
			}
			
			if(balance > 50000)
			{
				throw runtime_error("Pan Card Required\n");
				return;
			}


			this->balance = this->balance + amount;
			cout<<amount<<"/- Credited to  your account new balance: "<<balance<<"/-\n";
		}


};
