#include<iostream>
#include"Array.h"
using namespace std;


Array::Array(int size)
{
    cout<<"Ctor"<<endl;
    this->size = size;
    
     this->arr = new int[this->size];
}
///its a copy ctor which is used to create a copy of an array object
/// where we are going to implement DEEP CPOY and SHALLOW COPY
Array::Array(const Array &A)            
{    //Coping A content  to this/invoking object A-------->Invoking Obj
    this->size = A.size;
    // this->arr = A.arr; //will create shallow copy whtch means it will copy the address then both opint to same array result in dangling pointer
    this->arr = new int[this->size];

    for(int i=0;i<this->size;i++){
        this->arr[i] = A.arr[i];
    }
}
void Array::Accept()
{
    for(int i=0;i<this->size;i++){
        cout<<"\nenter "<<i+1<<" element: ";
        cin>>this->arr[i];
    }
}

void Array::Display()
{
    for(int i=0;i<this->size;i++){
        cout<<this->arr[i]<<" ";
    }
    cout<<endl;
}

int Array::GetAtIndex(int idx)
{
    return this->arr[idx];
}

void Array::SetAtIndex(int idx,int value)
{
    this->arr[idx] = value;
    count++;
}

int Array::at(int idx)
{
    return this->arr[idx];
}

int& Array::push(int idx)
{ 
   count++;
   return this->arr[idx];
}

int& Array::operator[](int idx)
{
    count++;
    return this->arr[idx];
}

int Array::Elements()
{
    return count;
}





Array::~Array()
{
    delete[] arr;
}