#include<iostream>
using namespace std;

int main(){
       
        float principal ,rate, amount;
	int year;
        cout<<"enter principal, rate, year respectively: ";
        cin>>principal>>rate>>year;	
   

	amount = principal;
	for(int i=0;i<year;i++){
		amount = amount*(1+rate/100);
	}

	float compound_intrest = amount-principal;

	cout<<"compound intrest is: "<<compound_intrest<<endl;
	


	return 0;

}
