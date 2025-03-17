

#include<iostream>
#include<vector>
#include<string>
using namespace std;



class Sport 
{
	protected:
		string name;
		float fees;
		bool isIndoor;
	public:
		Sport(): name(""),fees(0),isIndoor(false) {}
		Sport(string name, double fees,bool isIndoor): name(name),fees(fees),isIndoor(isIndoor) {}
		bool isIndoorGame(){
				return isIndoor;
		}
		virtual void display() const
		{
			cout<<"Sport: "<<name<<", Fees: "<<fees<<", Is Indoor: "<<isIndoor<<endl;
		}
		virtual ~Sport(){}
};

class IndoorGame: public Sport
{
	private:
		string venueType;
	public:
		IndoorGame():venueType(""),Sport() {}
		IndoorGame(string venueType, string name, float fees):venueType(venueType),Sport(name,fees,true) {}
		void display() const
		{
			cout<<"Indoor Game->";
			Sport::display();
			cout<<"Venue: "<<venueType<<endl;
		}
		 
};

class OutdoorGame: public Sport
{
	private:
		string groundType;
	public:
		OutdoorGame():groundType(""),Sport() {}
		OutdoorGame(string venueType, string name, float fees):groundType(venueType),Sport(name,fees,false) {}
		void display() const
		{
			cout<<"Outdoor Game ->";
			Sport::display();
			cout<<"Ground: "<<groundType<<endl;
		}
};

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
			cout<<"--------------------------\n";
			cout<<"Player Id: "<<id<<", Name: "<<player_name<<endl;
			cout<<"Registerd Sports"<<endl;
			// for (const auto &sport : sports) {  
			// 	sport->display();
			// }
			//similar to 
			vector<Sport*>::const_iterator it = sports.begin();
			for(;it!=sports.end();it++){
			 (*it)->display();
			}
			cout<<"--------------------------\n";
		}
		void enrollSport(Sport* sport) {
			sports.push_back(sport);
		}

		bool playsIndoor() const {
			for (const auto& sport : sports)
				if (sport->isIndoorGame()) return true;
			return false;
		}
	
		bool playsOutdoor() const {
			for (const auto& sport : sports)
				if (sport->isIndoorGame()) return true;
			return false;
		}

		int GetId(){
			return id;
		}
};