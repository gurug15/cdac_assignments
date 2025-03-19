#include <iostream>
#include <vector>
#include <memory>

using namespace std;

// Base class: Subscription
class Subscription {
protected:
    string subscriptionName;
    double fees;
public:
    Subscription(string name, double price) : subscriptionName(name), fees(price) {}

    virtual void displayFeatures() const = 0; // Pure virtual function
    string getName() const { return subscriptionName; }
    double getFees() const { return fees; }
};

// Derived class: BasicSubscription
class BasicSubscription : public Subscription {
public:
    BasicSubscription() : Subscription("Basic Subscription", 100.0) {}

    void displayFeatures() const override {
        cout << "Limited access to content" << endl;
    }
};

// Derived class: PremiumSubscription
class PremiumSubscription : public Subscription {
public:
    PremiumSubscription() : Subscription("Premium Subscription", 300.0) {}

    void displayFeatures() const override {
        cout << "Unlimited access to content and priority support" << endl;
    }
};

// User class
class User {
private:
    int id;
    string userName;
    vector<shared_ptr<Subscription>> subscriptions;
public:
    User(int uid, string name) : id(uid), userName(name) {}

    void addSubscription(shared_ptr<Subscription> sub) {
        subscriptions.push_back(sub);
    }

    int getId() const { return id; }
    string getName() const { return userName; }
    
    bool hasBasicSubscription() const {
        for (const auto &sub : subscriptions) {
            if (sub->getName() == "Basic Subscription") return true;
        }
        return false;
    }

    bool hasPremiumSubscription() const {
        for (const auto &sub : subscriptions) {
            if (sub->getName() == "Premium Subscription") return true;
        }
        return false;
    }

    void displaySubscriptions() const {
        cout << "User ID: " << id << ", Name: " << userName << " has the following subscriptions:\n";
        for (const auto &sub : subscriptions) {
            cout << "- " << sub->getName() << " (Fees: $" << sub->getFees() << ")\n";
            sub->displayFeatures();
        }
    }
};

// Global storage for users
vector<User> users;

// Function to add a new user
void addNewUser() {
    int id;
    string name;
    cout << "Enter User ID: ";
    cin >> id;
    cout << "Enter User Name: ";
    cin.ignore();
    getline(cin, name);
    users.emplace_back(id, name);
    cout << "User added successfully!\n";
}

// Function to enroll a user into a subscription
void enrollUserInSubscription() {
    int userId, choice;
    cout << "Enter User ID: ";
    cin >> userId;

    // Find user
    auto it = find_if(users.begin(), users.end(), [&](const User &u) { return u.getId() == userId; });
    if (it == users.end()) {
        cout << "User not found!\n";
        return;
    }

    cout << "Select Subscription:\n1. Basic Subscription\n2. Premium Subscription\nEnter choice: ";
    cin >> choice;

    shared_ptr<Subscription> sub;
    if (choice == 1)
        sub = make_shared<BasicSubscription>();
    else if (choice == 2)
        sub = make_shared<PremiumSubscription>();
    else {
        cout << "Invalid choice!\n";
        return;
    }

    it->addSubscription(sub);
    cout << "Subscription added successfully!\n";
}

// Function to display users with Basic Subscription
void displayUsersWithBasic() {
    cout << "\nUsers with Basic Subscription:\n";
    for (const auto &user : users) {
        if (user.hasBasicSubscription()) {
            cout << "- " << user.getName() << " (User ID: " << user.getId() << ")\n";
        }
    }
}

// Function to display users with Premium Subscription
void displayUsersWithPremium() {
    cout << "\nUsers with Premium Subscription:\n";
    for (const auto &user : users) {
        if (user.hasPremiumSubscription()) {
            cout << "- " << user.getName() << " (User ID: " << user.getId() << ")\n";
        }
    }
}

// Function to display all users with their subscriptions
void displayAllUsersWithSubscriptions() {
    cout << "\nAll Users and Their Subscriptions:\n";
    for (const auto &user : users) {
        user.displaySubscriptions();
        cout << "--------------------\n";
    }
}

// Main menu function
void menu() {
    int choice;
    do {
        cout << "\nSubscription Management System\n";
        cout << "1. Add New User\n";
        cout << "2. Enroll User into Subscription\n";
        cout << "3. Display Users with Basic Subscription\n";
        cout << "4. Display Users with Premium Subscription\n";
        cout << "5. Display All Users with Their Subscriptions\n";
        cout << "6. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: addNewUser(); break;
            case 2: enrollUserInSubscription(); break;
            case 3: displayUsersWithBasic(); break;
            case 4: displayUsersWithPremium(); break;
            case 5: displayAllUsersWithSubscriptions(); break;
            case 6: cout << "Exiting program...\n"; break;
            default: cout << "Invalid choice! Try again.\n";
        }
    } while (choice != 6);
}

// Main function
int main() {
    menu();
    return 0;
}
