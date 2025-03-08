#include<iostream>
using namespace std;

void swap(int &a, int &b){
	int temp =a;   // temp stores value of actual/real a
	a=b;           //the real a swaps with b
	b=temp;        // the real b swap with temp which stores a
}

void swapbypoint(int *a, int *b){
	int temp = *a;
       *a = *b;
       *b = temp;
}       

int main(){
	int a,b;
	cout<<"enter a: ";
	cin>>a;
	cout<<"enter b: ";
	cin>>b;

	swap(a,b);
        
	cout<<"a is:"<<a<<" b is:"<<b<<endl;

	return 0;
}
