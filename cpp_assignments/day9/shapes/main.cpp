
#include<iostream>
using namespace std;

class Shape
{
	public:
		Shape()
		{
			cout<<"Shape::Shape"<<endl;
		}
		void Accept()
		{
			cout<<"Shape Accept Function"<<endl;
		}
		virtual void Display()
		{
			cout<<"Shape Display function"<<endl;
		}
		int CalcArea();
		int CalcPeri();
};
class Rect : public Shape
{
	public:
		Rect()
		{
			cout<<"Shape::Rect"<<endl;
		}
		void Accept()
		{
			cout<<"Rect Accept Function"<<endl;
		}
		void Display()
		{
			cout<<"Rect Display function"<<endl;
		}

};

class Square: public Shape
{
	public:
		Square()
		{
			cout<<"Shape::Square"<<endl;
		}
		void Accept()
		{
			cout<<"Square Accept Function"<<endl;
		}
		void Display()
		{
			cout<<"Square Display function"<<endl;
		}

};


class Circle: public Shape
{
	public:
		Circle()
		{
			cout<<"Shape::Circle"<<endl;
		}
		void Accept()
		{
			cout<<"Circle Accept Function"<<endl;
		}
		void Display()
		{
			cout<<"Circle Display function"<<endl;
		}

};


int main(){
	
	Circle c;
	Shape *s = &c;

	s->Display();


	return 0;
}
