#include<iostream>
using namespace std;

int digitsum(int n);

int main(){
	int l;
	cout<<"enter number: ";
	cin>>l;
	cout<<digitsum(l)<<endl;
	return 0;
}


int digitsum(int n){
      int sum =0;
	while(n>0){
	   sum = sum + n%10;
	   n = n/10;
	}

	return sum;
}

