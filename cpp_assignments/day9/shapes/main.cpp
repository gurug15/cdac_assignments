#define _USE_MATH_DEFINES
#include <cmath>
#include<iostream>
using namespace std;


class Shape
{
	public:
		Shape()
		{
			cout<<"Shape::Shape"<<endl;
		}
		virtual void Accept()
		{
			cout<<"Shape Accept Function"<<endl;
		}
		virtual void Display() 
		{
			cout<<"Shape Display function"<<endl;
		}
		virtual float CalcArea()=0;
		virtual float CalcPeri()=0;
};
class Rect : public Shape
{
	private:
	int len,bdh;
	public:
		Rect(): len(0), bdh(0)
		{
			cout<<"Shape::Rect"<<endl;
		}
		void Accept()
		{
			cout<<"Rect Accept Function"<<endl;
			cout<<"Lenngth: ";
			cin>>len;
			cout<<"breadth: ";
			cin>>bdh;
		}
		void Display() 
		{
			cout<<"Rect Display function"<<endl;
			cout<<"Area: ";
			cout<<this->CalcArea()<<endl;
			cout<<"Perimeter: ";
			cout<<this->CalcPeri()<<endl;
		}
		float CalcArea(){
            return len*bdh;
		}

		float CalcPeri(){
			return 2*(len+bdh);
		}

};

class Square: public Shape
{
	private:
	int len;
	public:
		Square(): len(0)
		{
			cout<<"Shape::Square"<<endl;
		}
		void Accept()
		{
			cout<<"Square Accept Function"<<endl;
			cout<<"Lenngth: ";
			cin>>len;
		}
		void Display()
		{
			cout<<"Square Display function"<<endl;
			cout<<"Area: ";
			cout<<this->CalcArea()<<endl;
			cout<<"Perimeter: ";
			cout<<this->CalcPeri()<<endl;
		}
		float CalcArea()
		{
			return this->len*this->len;
		}
		float CalcPeri()
		{
			return 4*len;
		}


};


class Circle: public Shape
{
	private:
	float rad;

	public:
		Circle(): rad(0)
		{
			cout<<"Shape::Circle"<<endl;
		}
		void Accept()
		{
			cout<<"Circle Accept Function"<<endl;
			cout<<"Lenngth: ";
			cin>>rad;
		}
		void Display()
		{
			cout<<"Circle Display function"<<endl;
			cout<<"Area: ";
			cout<<this->CalcArea()<<endl;
			cout<<"Perimeter: ";
			cout<<this->CalcPeri()<<endl;
		}
		float CalcArea()
		{
			return M_PI*rad*rad;
		}
		float CalcPeri()
		{
			return 2*M_PI*rad;
		}

};


int main(){
	
	Circle c;
	Shape *s = &c;

	s->Display();


	return 0;
}
