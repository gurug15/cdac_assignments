#include<iostream>
#include<string>
#include<vector>
#include"sports.cpp"
// #include"player.cpp"
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
    cin>>type;
    cout<<(type==1?"Entee venue type: ":"Enter ground type: ");
    cin.ignore();
    getline(cin,gameType);


    if(type == 1)
    {
        gsports.push_back(new IndoorGame(gameType,name,fees));
    }else if(type == 2){
        gsports.push_back(new OutdoorGame(gameType,name,fees));
    }else{
        cout<<"invalid input";
    }
    
    cout<<"Sports added succesfully";

}

Player* findPlayerById(int pid,  vector<Player>& players) {
    for (int i = 0; i < players.size(); i++) {
        if (players[i].GetId() == pid) {
            return &players[i];  // Return address of player object
        }
    }
    return nullptr; // Not found
}

void enrollPlayer(){
    int pid , sid;
    cout<<"Enter Player Id: ";
    cin>>pid;
    cout<<"Avalable Sports\n";
    //vector<Sport*>::iterator it = gsports.begin();
    for(int i=0;i<gsports.size();i++){
        cout<<i+1<<". ";
        gsports[i]->display();
    }
    cout<<"select Sports No: ";
    cin>>sid;
    Player *foundPlr = findPlayerById(pid,players);

    if(foundPlr != nullptr && sid > 0 && sid <= gsports.size())
    {   
        foundPlr->enrollSport(gsports[sid-1]);
        cout<<"Player Enrolled Succesfully";

    }else{
        cout<<"Invalid Selection / No player Found \n";
    }
}

void displayIndoorPlayers() {
    cout << "\nPlayers Enrolled in Indoor Games:\n";
    for (const auto& player : players)
        if (player.playsIndoor())
            player.display();
}

void displayOutdoorPlayers() {
    cout << "\nPlayers Enrolled in Outdoor Games:\n";
    for (const auto& player : players)
        if (player.playsOutdoor())
            player.display();
}

void displayAllPlayers(){
    vector<Player>::iterator it = players.begin();
    for(it;it!=players.end();it++){
        it->display();
    }
}

void clearSports()
{
    for (int i = 0; i < gsports.size(); i++) {
        delete gsports[i];  // Free memory
    }
    gsports.clear();
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
    clearSports();
    return 0;
}