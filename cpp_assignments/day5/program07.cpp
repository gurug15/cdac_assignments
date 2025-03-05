#include<iostream>
using namespace std;


void multiply(int * arr, int n){

	for(int i=0;i<n;i++){
		arr[i]= arr[i]*2;
	}
}



int main(){
       int n;
       cout<<"enter total numbers: ";
       cin>>n;
       
       int * arr = new int[n];
       
       cout<<"enter numbers:"<<endl;
       
       for(int i=0;i<n;i++){
             cin>>arr[i];
       }
       
       multiply(arr,n);


       for(int i=0;i<n;i++){
             cout<<arr[i]<<" ";
       }

	return 0;
}
