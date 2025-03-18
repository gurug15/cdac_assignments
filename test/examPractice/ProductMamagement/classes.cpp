#include<iostream>
#include<cstring>
using namespace std;

class Product
{
	private:
	 	int id;
		char name[30];
		float price;
	public:
		Product():id(0),name(""),price(0) {}
		Product(int id,char *name,float price): id(id), price(price)
		{
			strcpy(this->name,name);
		}
		float getPrice(){
			return price;
		}
		virtual void display(){
			cout<<"Product"<<endl;
			cout<<"________________________\n";
			cout<<"ID: "<<id;
			cout<<" name: "<<name;
			cout<<" price: "<<price;
		}
		virtual ~Product() {}
};

class Book: public Product
{
	private:
		char author[30];
	public:
		Book():Product(),author(""){}
		Book(int id,char *name,float price,char *author):Product(id ,name,price)
		{
			strcpy(this->author,author);
		}
		void display(){
			Product::display();
			cout<<" Author: "<<author<<endl;
			cout<<"____________________\n";
		}
};
class Watch: public Product
{
	private:
		char type[15];
	public:
		Watch():Product(),type("analog"){}
		Watch(int id,char *name,float price,char *type):Product(id ,name,price)
		{
			strcpy(this->type,type);
		}
		void display(){
			Product::display();
			cout<<"Type: "<<type<<endl;
			cout<<"____________________\n";
		}
};
