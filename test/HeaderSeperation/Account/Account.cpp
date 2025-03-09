#include<iostream>
#include<string>
#include"Account.h"
using namespace std;


    Account::Account(): name("N/A"), addr("N/A"), balance(0)
    {
        accountNumber = AccNo;
        AccNo = AccNo + 12321;
        total++;
        
       cout<<"Default ctor called"<<this<<endl;
    }
    Account::Account(string name, string addr, long balance): name(name),addr(addr),balance(balance)
    {
       accountNumber = AccNo;
       AccNo = AccNo + 12321;
       total++;
       cout<<"Param ctor called"<<this<<endl;
    }
    void Account::Accept()
    {
        cout << "\nEnter name: ";
        cin >> this->name;
        cout << "Enter address: ";
        cin >> this->addr;
        cout << "Enter Balance: ";
        cin >> this->balance;
        cout << "Accept function called. This pointer: " << this << endl;
    }

    void Account::Display() const
    {
        cout << "Account #: " << accountNumber << "\t";
        cout << "Name: " << this->name << "\t";
        cout << "Address: " << this->addr << "\t";
        cout << "Balance: $" << this->balance << "\t";
        cout << "Memory Address: " << this << endl;
    }

    void Account::SetDepositMoney(int amount)
    {
        if(amount<0){
            cout<<"Invalid amount";
        }else{
            this->balance = this->balance + amount;
            cout<<"amout deposited Succesfully balance $"<<this->balance<<endl;
        }
    }

    void Account::SetWithdrawMoney(int amount)
    {
        if(this->balance>amount && amount>0){
            this->balance = this->balance - amount;
            cout<<"amout WithDrawn Succesfully balance $"<<this->balance<<endl;
        }else{
            cout<<"insufficient balance";
        }
    }

    int Account::GetBalance()
    {
        return this->balance;
    }

    int Account::GetAccountNumber(){
        return accountNumber;
    }

    void Account::GetAccounts()
    {
        cout<<"total accounts are: "<<total<<endl;
    }


long Account::AccNo = 1000000;
int Account::total = 0;