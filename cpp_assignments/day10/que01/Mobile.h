#include<iostream>
using namespace std;



class MobilePhone
{
	private:
		char serialNo[30],modelNo[30],brandName[30];
		int price;
	public:
		MobilePhone();
		void Accept();
		void Write(fstream &fout);
		int GetPrice();
		//bool Read(fstream &fin);
		void display();
	
};


