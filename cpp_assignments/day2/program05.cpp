#include<iostream>
using namespace std;

float CircleArea(int rad){
    
	return (float(22)/7)*rad*rad; 
}

int RectArea(int l,int b){
	return l*b;
}

int SquareArea(int s){
	return s*s;
}

int main(){
        char ch = 'C';
	cout<<"Choose to find area"<<endl;
	cout<<" S for Square\n R for Rectangle\n C for Circle\n type the char: ";
	cin>>ch;


	switch(ch)
	{
		case 'S':{
		         int s;
			 cout<<"Enter side of Square"<<endl;
			 cin>>s;
			 cout<<"Area of Square is :"<<SquareArea(s);
			 cout<<endl;
			 };
			 break;
		
		case 'R':{
		         int l,b;
			 cout<<"Enter length and breadth of Rectangle"<<endl;
			 cin>>l>>b;
			 cout<<"Area of rectangle is :"<<RectArea(l,b);
			 cout<<endl;
			 };
			 break;
	
		case 'C':{
		         int s;
			 cout<<"Enter radious of Circle"<<endl;
			 cin>>s;
			 cout<<"Area of Circle is :"<<CircleArea(s);
			 cout<<endl;
			 };
			 break;
	        default: {
				 cout<<"enter a valid char"<<endl;
			 }
	}	 
    return 0;
}
