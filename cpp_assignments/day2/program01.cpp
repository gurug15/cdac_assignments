#include<iostream>
#include<cmath>
using namespace std;





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


  int main(){
        int a,b,c;
	cout<<"enter a,b,c constants  from quadratic equation: ";
	cin>>a>>b>>c;
	cout<<"root of the equation is: "<<QuadraticEquation(a,b,c)<<endl;

  	return 0;
  }
