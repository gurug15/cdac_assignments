#include<iostream>
using namespace std;


int facto(int n){

	if(n<=1){
		return 1;
	}
	return n * facto(n-1);
}

void printFact(int n){
	for(int i=0;i<=n;i++){
		cout<<facto(i)<<" ";
	}
	cout<<endl;
}

int main(){
	
        int n;
	cout<<"enter a number:";
	cin>>n;
	//cout<<"the factorial is: "<<facto(n)<<endl;
	printFact(n);
	return 0;
}
