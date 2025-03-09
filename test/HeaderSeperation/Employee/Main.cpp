#include<iostream>
#include<string>
#include"Employee.h"
using namespace std;


void swap(Employee &a,Employee &b){
    Employee temp = a;
    a=b;
    b= temp; 
}


void sortSalary(Employee One[], int no){
    for(int i=0;i<no;i++){
        for(int j=0;j<no-i-1;j++){
            if(One[j].getSalary()>One[j+1].getSalary()){
                swap(One[j],One[j+1]);
            }
        }
    }
}

void sortEmployeeId(Employee One[], int no){
    for(int i=0;i<no;i++){
        for(int j=0;j<no-i-1;j++){
            if(One[j].getEmployeeId()>One[j+1].getEmployeeId()){
                swap(One[j],One[j+1]);
            }
        }
    }
}

void PrintArray(Employee One[], int n){
    for(int i=0;i<n;i++){
        One[i].Display();
    }
}


int main(){
    int no;
    cout<<"Enter no of employee: ";
    cin>>no;
    //Employee *One = new Employee[no];
    Employee One[no];
    //accepting Data:
    for(int i=0;i<no;i++){
        One[i].Accept();
    }

    cout<<"Printing sorted array according to salary:\n";
    sortSalary(One,no);
    PrintArray(One,no);
    sortEmployeeId(One,no);
    cout<<"Printing sorted Employee Id:"<<endl;
    PrintArray(One,no);
}