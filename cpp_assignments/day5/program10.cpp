#include<iostream>
using namespace std;

void printFun(string arr[],int n){
	for(int i=0;i<n;i++){
		cout<<arr[i]<<" ";
		//arr++;
	}
}



int main(){
       //int n;
       string arr[] = {"one","two","three","four"};
       printFun(arr,4);
	return 0;
}
