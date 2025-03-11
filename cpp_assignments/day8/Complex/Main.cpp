#include<iostream>
#include"Complex.h"
using namespace std;



int main()
{ 
	Complex C1(10,20),C2(20,30);
	C1.Display();
	C2.Display();
	Complex C3 = C1 + C2;
	C3.Display();
	C3.TotalObj();


	return 0;
}
