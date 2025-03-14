#include<iostream>
#include"Array.cpp"
using namespace std;


int main(){

    Array <float>A;
    A.Accept();
    A.Display();
    A.Sort();
    cout<<"After Sort----";
    A.Display();

    return 0;
}