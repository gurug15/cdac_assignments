#ifndef  __Complex__
#define  __Complex__

#include<iostream>

using namespace std;

class Complex
{
	private:
		int real,img;
		static int count;

	public:
		Complex();
		Complex(int,int);
		Complex(const Complex&);
		Complex operator+(const Complex&);
		Complex operator-(const Complex&);
		Complex operator*(const Complex&);
		void Display();	
		static void TotalObj();


};

























#endif
