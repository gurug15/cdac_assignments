#include<iostream>
using namespace std;


int main(){
	int num, pow, squ;
	cout<<"enter number and power respectively: ";
	cin>>num>>pow;
	squ = 1;
	for(int i=1;i<=pow;i++){
               squ = squ * num;
	}
	cout<<"power of number is: "<<squ<<endl;

	return 0;
}
