#ifndef ___Array_H__
#define ___Array_H__
#include<iostream>
using namespace std;


class Array {
    private:
    int count=0;
    int size;
    int * arr;
   
    public:
    Array(int);
    //Array(const Array &A);
    void Accept();
    void Display();
    //int GetAtIndex(int);
    //void SetAtIndex(int,int);
    //int at(int);
    //int& push(int);
    //int Elements();
    void sort();
    int FindMax();
    int FindMin();
    //int& operator[](int);
    ~Array();
};
#endif
