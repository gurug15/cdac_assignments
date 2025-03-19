#ifndef CMP__
#define CMP__
#include<iostream>
using namespace std;
class Complex
{
    private:
        int real;
        int img;
    public:
        Complex();
        Complex(int real,int img);
        friend Complex operator++(Complex &c,int);
        friend Complex operator++(Complex &c);
        friend Complex operator+(Complex &c,int);
        friend Complex operator+(int,Complex &c);
        friend ostream& operator<<(std::ostream &out, const Complex &c);
        friend istream& operator>>(istream &in, Complex &c);

};
#endif