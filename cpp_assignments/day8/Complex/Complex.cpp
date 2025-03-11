#include<iostream>
#include"Complex.h"
using namespace std;


Complex::Complex(): real(0),img(0)
{
	count++;

}

Complex::Complex(int real,int img):real(real),img(img)
{
	count++;
}

Complex::Complex(const Complex &C)
{
	this->real = C.real;
	this->img = C.img;
}

Complex Complex::operator+(const Complex &C)
{
	return Complex(this->real+C.real,this->img+C.img);
}

Complex Complex::operator-(const Complex &C)
{
	return Complex(this->real-C.real,this->img-C.img);
}

Complex  Complex::operator*(const Complex &C)
{
   return Complex((this->real*C.real -this->img*C.img),(this->real*C.img + this->img*C.real));}


void Complex::Display()
{
	cout<<"Complex No is: ["<<this->real<<"+"<<this->img<<"i]"<<endl;
}











int Complex::count=0;
void Complex::TotalObj(){
	cout<<"Count is: "<<count<<endl;
}


