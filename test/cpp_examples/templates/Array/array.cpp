#include<iostream>
using namespace std;

template<class T>
class Array 
{
    private:
    T *p;
    int size;
    int count = 0;
    public:
    Array(): size(5)
    {
        p = new T[size];
        count++;

    }
    Array(int size): size(size)
    {
        p = new T[size];
        count++;
    }
    void Accept()
    {
        cout<<"Enter Size of array: ";
        cin>>this->size;
        cout<<"Enter Elements:"<<endl;
        for(int i=0;i<size;i++){
            cout<<"enter at "<<i<<" index: ";
            cin>>p[i];
        }
    }    
    void Display()
    {
        for(int i=0;i<size;i++){
            cout<<"Element at "<<i<<" index: ";
            cout<<p[i]<<endl;
        }
    }
    void Sort()
    {
        for(int i=0;i<size;i++){
            T temp =0;
            for(int j=0;j<size-i-1;j++){
                 if(p[j]>p[j+1])
                 {
                    temp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp;
                 }
            }
        }
    }
    
    T at(int idx)
    {
        return p[idx];
    }
    T& operator[](int idx)
    {
            count++;
            return p[idx];
    }

    ~Array(){
        delete[] p;
    }
};
