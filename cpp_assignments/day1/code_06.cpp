#include<iostream>
using namespace std;

int area(int l, int b);

int main(){
	int l,b;
	cout<<"enter length and breadth respectively: ";
	cin>>l>>b;
	cout<<area(l,b)<<endl;
	return 0;
}


int area(int l, int b){
	return l*b;
}
