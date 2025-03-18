#include<iostream>
#include"complex.h"
using namespace std;


        Complex::Complex() : real(0), img(0) {}
        Complex::Complex(int real,int img): real(real), img(img){}
        Complex operator++(Complex &c,int)
        {
            Complex temp = c;
            c.real++;
            c.img++;
            return temp; 
        }
        Complex operator++(Complex &c)
        {
            c.real++;
            c.img++;
            return c; 
        }
        Complex operator+(Complex &c,int val)
        {
            return Complex(c.real + val, c.img);
        }
        Complex operator+(int val,Complex &c)
        {
            return Complex(c.real + val, c.img);
        }
        ostream& operator<<(std::ostream &out, const Complex &c) {
            out << c.real << " + " << c.img << "i";
            return out;
        }
        istream& operator>>(istream &in, Complex &c){
            in>>c.real>>c.img;
            return in;
        }