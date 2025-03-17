#include<iostream>
#include<cstring>
#include<fstream>
using namespace std;



class Book
{
	private:
		int bookId;
		char title[50];
		char author[50];
		float price;
	public:
	       	Book(): bookId(0),title(""),author(""),price(0){}
		Book(int id,char *title,char *author,float price): bookId(id), price(price) {
			strcpy(this->title,title);
			strcpy(this->author,author);
		}	
		void Accept()
		{
			cout << "Enter Book ID: ";
       	 		cin >> bookId;
        		cin.ignore();
        		cout << "Enter Title: ";
        		cin.getline(title,50);
        		cout << "Enter Author: ";
       		 	cin.getline(author,50);
        		cout << "Enter Price: ";
        		cin >> price;
		}
		void Display()
		{
			cout << "Book ID: " << bookId << "\n";
        		cout << "Title: " << title << "\n";
        		cout << "Author: " << author << "\n";
        		cout << "Price: " << price << "\n";
        		cout << "----------------------\n";	
		
		}
		int getBookId(){
			return bookId;
		}
		float getPrice(){
			return price;
		}
		void write(fstream &fout)
		{
			fout.write((char*)this,sizeof(Book));
		}

};
