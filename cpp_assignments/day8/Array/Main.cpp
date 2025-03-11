#include<iostream>
#include"Array.h"
using namespace std;


int main()
{
	int size;
	cout<<"ENter No of elements: ";
	cin>>size;
	Array arr(size);
	arr.Accept();
	arr.Display();
	arr.sort();
	arr.Display();
	cout<<"Max is:"<<arr.FindMax()<<endl;
	cout<<"Min is:"<<arr.FindMin()<<endl;
    

	return 0;
}
  
























/*
    Array A(4);
    // A.Accept();
    // A.Display();
    //////////////
    // A.SetAtIndex(2,10);
    // A.SetAtIndex(0,20);
    // A.SetAtIndex(1,38);
    // A.SetAtIndex(3,40);
    // A.SetAtIndex(4,50);
    // cout<<"at index 2"<<A.GetAtIndex(2)<<endl;
    //////////////
    // A.push(0) = 10;
    // A.push(2) = 20;
    // A.push(3) = 30;
    // A.push(1) = 20;

    // cout<<A.at(0)<<endl;
    // cout<<A.at(1)<<endl;
    // cout<<A.at(2)<<endl;
    // cout<<A.at(3)<<endl;
    /////////////////
    A[0] = 10;
    A.operator[](1) = 20;
    A[2] = 30;
    A[3] = 40;
    A[4] = 50;
    cout<<"Elements are: "<<A.Elements()<<endl;
    for(int i=0;i<A.Elements();i++){
        cout<<" "<<A.at(i);
    }
    */
