#include<iostream>
using namespace std;

void swap(int &a, int &b){
	int temp = a;
	a=b;
	b=temp;
}

int main(){
	int a,b;
	cout<<"enter two numbers a,b:";
	cin>>a>>b;
	swap(a,b);
	cout<<"a is:"<<a<<" b is:"<<b<<endl;

	return 0;
}

