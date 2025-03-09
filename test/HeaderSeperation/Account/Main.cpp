#include<iostream>
#include<string>
#include"Account.h"
using namespace std;


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