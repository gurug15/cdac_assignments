#include<string>
#include<iostream>
#include"Player.h"
using namespace std;
Player::Player() : name(""), age(0)
{
cout<<"\nPlayer::Player()"<<endl;
}
Player::Player(string name, int age): name(name), age(age)
{
cout<<"\nPlayer::Player(string, int)"<<endl;
}
void Player::Accept()
{
	cout<<"\n Please enter name and age"<<endl;
	getline(cin,name);
	cin>>age;
}

void Player::Display()
{
	cout<<"\n Player data"<<endl;
	cout<<"\n [Name="<<name<<", Age="<<age<<" ]" ;
}
Player::~Player()
{
cout<<"\nPlayer::~Player()"<<endl;
}
