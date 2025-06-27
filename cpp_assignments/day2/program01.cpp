#include<iostream>
#include<cmath>
using namespace std;

 class Abc {
      public:
       virtual void funca() = 0;

};

class BBc : public Abc{
      public:
       void funca(){
            cout<<"ehllo";
      }
};





  int main(){
     
      Abc* a = new BBc();
      a->funca();

      delete a;
  	return 0;
  }

  
double QuadraticEquation(int a, int b,int c){
  	
       double x=0,y=0;

       x= (-b-sqrt((b*b)-4*a*c))/double(2*a);
       
       y= (-b+sqrt((b*b)-4*a*c))/double(2*a);
 
      if(x>=0){
       return x;
       }
       else{
       return y;
       }
  }

