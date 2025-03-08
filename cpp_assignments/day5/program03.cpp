#include<iostream>
using namespace std;


void insertArrayElements(char arr[],int n){
	cout<<"enter char elements\n";
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
}


/*
void printarray(const int const *arr,const int n){

	for(int i=0;i<n;i++){
		cout<<arr[i]
	}
}
*/



int main(){
	int n;
	cout<<"enter number of characters:";
	cin>>n;
	char *arr = new char[n+1];
	insertArrayElements(arr,n);
	cout<<arr<<endl;



	return 0;
}
