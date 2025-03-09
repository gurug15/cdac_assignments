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
    Account(): name("N/A"), addr("N/A"), balance(0)
    {
        accountNumber = AccNo;
        AccNo = AccNo + 12321;
        total++;
        
       cout<<"Default ctor called"<<this<<endl;
    }
    Account(string name, string addr, long balance): name(name),addr(addr),balance(balance)
    {
       accountNumber = AccNo;
       AccNo = AccNo + 12321;
       total++;
       cout<<"Param ctor called"<<this<<endl;
    }
    void Accept()
    {
        cout << "\nEnter name: ";
        cin >> this->name;
        cout << "Enter address: ";
        cin >> this->addr;
        cout << "Enter Balance: ";
        cin >> this->balance;
        cout << "Accept function called. This pointer: " << this << endl;
    }

    void Display() const
    {
        cout << "Account #: " << accountNumber << "\t";
        cout << "Name: " << this->name << "\t";
        cout << "Address: " << this->addr << "\t";
        cout << "Balance: $" << this->balance << "\t";
        cout << "Memory Address: " << this << endl;
    }

    void SetDepositMoney(int amount)
    {
        if(amount<0){
            cout<<"Invalid amount";
        }else{
            this->balance = this->balance + amount;
            cout<<"amout deposited Succesfully balance $"<<this->balance<<endl;
        }
    }

    void SetWithdrawMoney(int amount)
    {
        if(this->balance>amount && amount>0){
            this->balance = this->balance - amount;
            cout<<"amout WithDrawn Succesfully balance $"<<this->balance<<endl;
        }else{
            cout<<"insufficient balance";
        }
    }

    int GetBalance()
    {
        return this->balance;
    }

    int GetAccountNumber(){
        return accountNumber;
    }

    static void GetAccounts()
    {
        cout<<"total accounts are: "<<total<<endl;
    }


};

long Account::AccNo = 1000000;
int Account::total = 0;


int findAccount(Account * Acc , int size, long accountNumber){
    if(size ==0){
        cout<<"No account created yet"<<endl;
        return -1;
       }
    for(int i=0;i<size;i++){
        if(Acc[i].GetAccountNumber() == accountNumber) {
            return i;
        }
    }
}



void DisplayAllAccounts(Account * Acc,int count){
   if(count ==0){
    cout<<"No account created yet"<<endl;
    return;
   }

   cout<<"----All Accounts----"<<endl;
   for(int i=0;i<count;i++){
    Acc[i].Display();
   }

}


int main(){

    int Size = 50;
    Account *AccArr = new Account[Size];
    int count = -1;
    int accCount =0;
    long AccountNo, amount;
    string name, address;
    
    while(count !=0) {
        cout << "\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====" << endl;
        cout << "1. Open New Account" << endl;
        cout << "2. Display All Accounts" << endl;
        cout << "3. Find Account and Display Details" << endl;
        cout << "4. Deposit Money" << endl;
        cout << "5. Withdraw Money" << endl;
        cout << "6. Display Total Number of Accounts" << endl;
        cout << "0. Exit" << endl;
        cout << "Enter your choice: ";
        cin>>count;

        switch(count) {
            case 1: {
                  if(accCount<Size){
                    cout<<"----Opening New Account----"<<endl;
                    AccArr[accCount].Accept();
                    cout<<"----Account Details---"<<endl;
                    AccArr[accCount].Display();
                    accCount++;
                  }else{
                    cout<< "Maximum account limit reached"<<endl;
                  }
                  break;
            }
            case 2: {
                cout<<"----Accounts---"<<endl;
                DisplayAllAccounts(AccArr,accCount);
                break;
            }
            case 3: {
                cout<<"---Find Account---"<<endl;
                cout<<"Enter Account No:";
                cin>>AccountNo;
                int index;
                index = findAccount(AccArr,accCount,AccountNo);
                if(index == -1) {
                    cout<<"No account Found Create One Press 1";
                }else{
                    cout<<"----Account Details----\n";
                    AccArr[index].Display();
                }
                break;
            }
            case 4: {
                cout<<"Enter Account No:";
                cin>>AccountNo;
                cout<<"\nEnter Amout too deposit:";
                cin>> amount;
                int index;
                index = findAccount(AccArr,accCount,AccountNo);
                if(index == -1) {
                    cout<<"No account Found Create One Press 1\n";
                }else{
                    cout<<"----Bank Transfer----\n";
                    AccArr[index].SetDepositMoney(amount);
                }
                break;
            }
            case 5: {
                cout<<"Enter Account No:";
                cin>>AccountNo;
                cout<<"\nEnter Withdraw Ammount:";
                cin>> amount;
                int index;
                index = findAccount(AccArr,accCount,AccountNo);
                if(index == -1) {
                    cout<<"No account Found Create One Press 1";
                }else{
                    cout<<"----Bank Transfer----\n";
                    AccArr[index].SetWithdrawMoney(amount);
                }
                break;
            }
            case 6: {
                Account::GetAccounts();
                break;
            }
            case 0:
            cout<<"Exiting Program....."<<endl;
            break;

            default: 
               cout<<"Invalid choice. Please Try Again."<<endl;
        }

    }


    delete[] AccArr;
    return 0;
}