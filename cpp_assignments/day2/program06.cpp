#include<iostream>
using namespace std;

void factorial(int n){
      int prod =1;
	for(int i=1;i<=n;i++){
           prod = prod * i;
	   cout<<prod<<" ";
	}
	cout<<endl;
}

int main(){

	int num;
	cout<<"enter a number";
	cin>>num;
	factorial(num);
	return 0;
}

