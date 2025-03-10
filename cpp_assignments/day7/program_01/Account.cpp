#include<iostream>
#include<string>
#include"Account.h"

using namespace std;

Account::Account(): name("N/A"), balance(0)
{	
	this->name=name;
	this->balance=0;
	cnt++;
	this->accNo = cnt;
}


Account::Account(string name,double balance) 
{
	this->name= name;
	this->balance = balance;
	cnt++;
	this->accNo = cnt;
}

void Account::Accept()
{
	cout<<"-----Create-Accout-----"<<endl;
	cout<<"Enter Name: ";
	cin>>this->name;
	cout<<"Enter Balance: ";
	cin>>this->balance;


}

void Account::Display()
{
	cout<<"-----Account Details-----"<<endl;
	cout<<"Account Number: "<<this->accNo<<endl;
	cout<<"Your Name: ";
	cout<<this->name<<endl;
	cout<<"Enter Balance: ";
	cout<<this->balance<<endl;
	cout<<"your Address: "<<this<<endl;
	
		
}
int Account::SetDepositMoney(int amount)
{	
	if(amount<0){
		cout<<"invalid amount"<<endl;
		return this->balance;
	}
	this->balance = this->balance + amount;

	return this->balance;
}
int Account::SetWithDrawMoney(int amount)
{
	if(amount<0 && amount>this->balance){
		cout<<"Invalid Amount"<<endl;
		return this->balance;
	}
	this->balance = this->balance - amount;

	return this->balance;
}

int Account::GetAccNo(){
	return this->accNo;
}
//static void Account::TotalAccounts(){


int Account::cnt=0;









