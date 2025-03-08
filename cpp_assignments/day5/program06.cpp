#include<iostream>
using namespace std;


void insertArrayElements(char arr[],int n){
	cout<<"enter char elements\n";
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
}

void swap(char * a, char *b){
	char temp = *a;
	*a=*b;
	*b=temp;
}


void RecRev(char * arr, int size, int s, int e){

	if(s==e || s>=size/2){
		return ;
	}
         swap(arr[s], arr[e]);
	 RecRev(arr,size,s+1,e-1);
}	


void reverseArr(char *arr, int n){
    for(int i=0;i<(n/2+1);i++){
          swap(arr[i], arr[n-i-1]);
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
	//reverseArr(arr,n);
	RecRev(arr,n,0,n-1);
	cout<<"rev: "<<arr<<endl;



	return 0;
}
