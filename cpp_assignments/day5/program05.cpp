#include<iostream>
using namespace std;

float Average(int *arr,int n){
	float avg;
	float sum=0;
	for(int i=0;i<n;i++){
           sum = sum + arr[i];
	}
        avg = sum/n;
	return avg;
}
void insertArrayElements(int arr[],int n){
        cout<<"enter numbers\n";
        for(int i=0;i<n;i++){
                cin>>arr[i];
        }
}


int main(){
       
	int n;
        cout<<"enter a num: "<<endl;
        cin>>n;
	int *arr = new int[n];
        insertArrayElements(arr,n);
        cout<<"average is: "<<Average(arr,n)<<endl;
  	


	return 0;
}
