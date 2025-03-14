#include<iostream>
#include"Mobile.h"
#include <fstream>
#include<string>
using namespace std;


const string fileName = "mobiles.dat";
void addMobile();
void displayAll();
void displaySorted();

int main() {
    int choice;
    do {
        cout << "\n1. Add Mobile Details";
        cout << "\n2. Display All Mobiles";
        cout << "\n3. Display Sorted Mobiles (by Price)";
        cout << "\n4. Exit";
        cout << "\nEnter your choice: ";
        cin >> choice;
        
        switch (choice) {
            case 1:
                addMobile();
                break;
            case 2:
                displayAll();
                break;
            case 3:
                displaySorted();
                break;
            case 4:
                cout << "Exiting..." << endl;
                break;
            default:
                cout << "Invalid choice! Try again." << endl;
        }
    } while (choice != 4);

    return 0;
}

void addMobile() {
    fstream fout(fileName, ios::app | ios::binary);
    if (!fout) {
        cout << "Error opening file!" << endl;
        return;
    }

    MobilePhone mob;
    mob.Accept();
    mob.Write(fout);
    fout.close();

    cout << "Mobile details saved successfully!" << endl;
}

void displayAll() {
    ifstream fin("mobiles.dat", ios::binary);
    if (!fin) {
        cout << "Error: Cannot open file." << endl;
        return;
    }

    MobilePhone mob;
    cout << "\n--- All Mobile Records ---\n";
    while (fin.read((char*)&mob, sizeof(MobilePhone))) {
        mob.display();
    }

    fin.close();
}

void displaySorted() {
    ifstream fin("mobiles.dat", ios::binary);
    if (!fin) {
        cout << "Error: Cannot open file." << endl;
        return;
    }

    MobilePhone mobiles[100]; 
    int count = 0;

    while (fin.read((char*)&mobiles[count], sizeof(MobilePhone))) {
        count++;
    }

    fin.close();

    // Sorting by price
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - i - 1; j++) {
            if (mobiles[j].GetPrice() > mobiles[j + 1].GetPrice()) {
                swap(mobiles[j], mobiles[j + 1]);
            }
        }
    }

    // Display sorted list
    cout << "\nMobiles sorted by price:\n";
    for (int i = 0; i < count; i++) {
        mobiles[i].display();
    }
}