#include<iostream>
using namespace std;

int  RecSum(int n){
   
	if(n<=1){
		return n;
	}
	return n+RecSum(n-1);
}

void printSum(int n){
	for(int i=0;i<=n;i++){
		cout<<RecSum(i)<<" ";
	}
	cout<<endl;
}

int main(){
	int num;
	cout<<"enter a number: ";
	cin>>num;
	//printSum(num);
	cout<<"\n";
	cout<<RecSum(num)<<endl;
	return 0;
}
