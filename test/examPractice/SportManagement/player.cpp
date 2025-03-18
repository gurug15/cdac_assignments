#ifndef Player
#define Player
#include<iostream>
#include<vector>
#include"sports.cpp"
using namespace std;



class Player
{
	private:
		int id;
		string player_name;
		vector<Sport*> sports;
	public:
		Player(): id(0), player_name("") {}
		Player(int id, string pName): id(id), player_name(pName) {}
		void display() const
		{
			cout<<"Player Id: "<<id<<", Name: "<<player_name<<endl;
			cout<<"Registerd Sports"<<endl;
			
			// for(auto &sports : )
		}
};
#endif
