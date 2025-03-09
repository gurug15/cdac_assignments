#include<iostream>
#include<string>
using namespace std;

class Account
{
    private:
    static long int AccNo;
    string name;
    string addr;
    long balance;
    long accountNumber;
    static int total;

    public:
    Account();
    Account(string name, string addr, long balance);
    void Accept();
    void Display() const;
    void SetDepositMoney(int amount);
    void SetWithdrawMoney(int amount);
    int GetBalance();
    int GetAccountNumber();
    static void GetAccounts();

};