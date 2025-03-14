#include<iostream>
#include<fstream>
#include"Mobile.h"
using namespace std;



		MobilePhone::MobilePhone(): serialNo(""),modelNo(""),brandName(""),price(0)
		{
		}
		void MobilePhone::Accept()
		{
			cout<<"Enter brandName"<<endl;
		        cin>>this->brandName;
		 	cout<<"Enter Model No:"<<endl;
			cin>>this->modelNo;
		 	cout<<"Enter Serial No"<<endl;
			cin>>this->serialNo;
		 	cout<<"Enter price"<<endl;
			cin>>this->price;

		}
		int MobilePhone::GetPrice(){
			return this->price;
		}
		void MobilePhone::Write(fstream &fout)
		{
			fout.write((char*)this,sizeof(MobilePhone));
		}
		// bool MobilePhone::Read(fstream &fin)
		// {
		// 	return fin.read((char*)this,sizeof(MobilePhone));
		// }
		void MobilePhone::display()
		{
			cout<<"brandName: "<<this->brandName;
		 	cout<<"\t\tModel No:"<<this->modelNo;
		 	cout<<"\t\tSerial No: "<<this->serialNo;
			cout<<"\t\tPrice: "<<this->price<<endl;
		}

	



