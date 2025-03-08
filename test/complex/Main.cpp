#include<iostream>
#include"Complex.h"
using namespace std;


int main(){
    Complex c1(90,30), c2(30,40), c4(50,40);
    //c1.Accept();
    c1.Display();
    
    Complex  c3 = c1 + c2 -c4;
    c3.Display();
    return 0;
}