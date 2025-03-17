#include<iostream>
#include<string>
#include<vector>
#include"sports.cpp"
#include"player.cpp"
using namespace std;



vector<Player> players;
vector<Sport*> gsports;

void addNewPlayer(){
    int id;
    string name;
    cout<<"Enter Player id: ";
    cin>>id;
    cout<<"Enter player name ";
    cin>>name;
    players.push_back(Player(id,name));
    cout<<"Player added Succesfully";
}

void addNewSport(){
    int type;
    string name, gameType;
    float fees;
    cout<<"Enter New Sports"<<endl;
    cout<<"Enter sport name: ";
    cin.ignore();
    getline(cin,name);
    cout<<"Enter fees: ";
    cin>>fees;
    cout<<"press 1 for indoor game and 2 for outdoor game: ";
    cin>>type
    cout<<(type==1?"Entee venue type: ":"Enter ground type: ");
    cin.ignore();
    getline(cin,gameType);


    if(type == 1)
    {
        gsports.push_back(new IndoorGame(gameType,name,fees));
    }else{
        gsports.push_back(new OutdoorGame(gameType,name,fees));
    }
    
    cout<<"Sports added succesfully";

}






void mainMenu()
{
    int choice;
    while (true) {
        cout << "\n1. Add New Player\n"
             << "2. Add New Sport\n"
             << "3. Enroll Player into Sport\n"
             << "4. Display Players with Indoor Games\n"
             << "5. Display Players with Outdoor Games\n"
             << "6. Display All Players\n"
             << "7. Exit\n"
             << "Enter your choice: ";
        cin >> choice;
        switch (choice) {
            case 1: addNewPlayer(); break;
            case 2: addNewSport(); break;
            case 3: enrollPlayer(); break;
            case 4: displayIndoorPlayers(); break;
            case 5: displayOutdoorPlayers(); break;
            case 6: displayAllPlayers(); break;
            case 7: cout << "Exiting program...\n"; return;
            default: cout << "Invalid choice! Try again.\n";
        }
    }
}



int main(){
    mainMenu();
    return 0;
}