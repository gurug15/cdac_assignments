#include<iostream>
using namespace std;

void swap(int *i,int *j){
     int *temp = i;
     i=j;
     j=temp;    
}

void sort(int *arr,int n){
    
	for(int i=0;i<n;i++){
		for(int j=0;j<n-1;j++){
			if(arr[j]>arr[j+1]){
				swap(arr[j],arr[j+1]);
			}
		}
	}
}

void printarr(int *arr, int n){
        cout<<"{";
	for(int i=0;i<n;i++){
		cout<<arr[i]<<",";
	}
	cout<<"}\n";
}

int main(){
	int n;
	cout<<"enter a num: ";
	cin>>n;
	int arr[n];
	cout<<"enter elements: ";
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
	sort(arr,n);
	printarr(arr,n);

	return 0;
}
