#include<iostream>
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
			cout<<"Sport: "<<name<<", Fees: "<<fees<<endl;
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
