#include<iostream>
#include<string>
#include"Account.h"
using namespace std;





void DisplayAccs(Account * Acc, int AccCount){
	if(AccCount==0){
		cout<<"NO accounts Created Yet"<<endl;
	        return;
	}
	for(int i=0;i<AccCount;i++){
		Acc[i].Display();
	}
}


int FindIndex(Account *Arr,int accNo,int accCount){
   if(accCount==0){
	   cout<<"No account Created Yet"<<endl;
	   return -1;
   }
   for(int i=0;i<accCount;i++){
	   if(Arr[i].GetAccNo()==accNo){
		   return i;
	   }
	   else{
		   return -1;
	   }
   }
   return -1;
}



int main(){
	int size = 50;
	int accCount = 0;
	int choice =-1;
	string name;
	double amount;
	int accNo;

	Account *Acc = new Account[size];
	while(choice != 0){
		cout<<"---------ACCOUNT ASSIGNMENT----------"<<endl;
		cout<<"Enter your choice"<<endl;
		cout<<"1-To Create An Account"<<endl;
		cout<<"2-To Deposit Money"<<endl;
		cout<<"3-To WithDraw Money"<<endl;
		cout<<"4-To Display All Account Details"<<endl;
		cout<<"0-To Exit The Menu"<<endl;
		cout<<"Enter your Choice: ";
		cin>>choice;
		switch(choice){
		case 1: {
				if(accCount>size){
					cout<<"Account limit reached"<<endl;
				}else{
					cout<<"---Enter Account Details---"<<endl;
					Acc[accCount].Accept();
					accCount++;
				}
				break;

			}
		case 2: {	
				cout<<"Enter Account No to deposit: ";
				cin>>accNo;
				int idx = FindIndex(Acc,accNo,accCount);
				if(idx<0){
					cout<<"No Account Found"<<endl;
					break;
				}
				cout<<"Enter the Amount to Deposit: ";
				cin>>amount;
				cout<<"The Deposited amount is: $"<<Acc[idx].SetDepositMoney(amount)<<endl;
				
				break;
			}
		case 3: {
				cout<<"Enter Account No to WithDraw: ";
				cin>>accNo;
				int idx = FindIndex(Acc,accNo,accCount);
				if(idx<0){
					cout<<"No Account Found"<<endl;
					break;
				}
				cout<<"Enter the Amount to WithDraw: ";
				cin>>amount;
				cout<<"The Deposited amount is: $"<<Acc[idx].SetWithDrawMoney(amount)<<endl;
				
				break;
			}
		case 4: {
				cout<<"------All Account Detils ------"<<endl;
				DisplayAccs(Acc,accCount);
				cout<<"-------------------------------"<<endl;
				break;
			}
		case 0: {
				cout<<"Exiting the menu"<<endl;
				break;
			}
		default:{
				cout<<"invalid choice"<<endl;
			}
		}
	}


	return 0;
}

