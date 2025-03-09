#include<iostream>
#include<string>
using namespace std;

class Account
{
    private:
    static long int AccNo;
    string name;         // Removed const to allow modifications
    string addr;         // Removed const to allow modifications
    long balance;
    long accountNumber;  // Individual account number
    static int total;

    public:
    Account(): name("N/A"), addr("N/A"), balance(0)
    {
        accountNumber = AccNo;
        AccNo = AccNo + 12321;
        total++;
        cout << "Default constructor called. This pointer: " << this << endl;
    }
    
    Account(string name, string addr, long balance): name(name), addr(addr), balance(balance)
    {
        accountNumber = AccNo;
        AccNo = AccNo + 12321;
        total++;
        cout << "Parameterized constructor called. This pointer: " << this << endl;
    }
    
    void Accept()
    {
        cout << "\nEnter name: ";
        cin >> this->name;
        cout << "Enter address: ";
        cin >> this->addr;
        cout << "Enter Balance: ";
        cin >> this->balance;
        cout << "Accept function called. This pointer: " << this << endl;
    }

    void Display() const
    {
       cout << "Account #: " << accountNumber << "\t";
       cout << "Name: " << this->name << "\t";
       cout << "Address: " << this->addr << "\t";
       cout << "Balance: $" << this->balance << "\t";
       cout << "Memory Address: " << this << endl;
    }

    void SetDepositMoney(long amount)
    {
        if (amount > 0) {
            this->balance = this->balance + amount;
            cout << "Deposit successful. New balance: $" << this->balance << endl;
        } else {
            cout << "Invalid deposit amount." << endl;
        }
    }

    void SetWithdrawMoney(long amount)
    {
        if (amount <= 0) {
            cout << "Invalid withdrawal amount." << endl;
        }
        else if (this->balance >= amount) {
            this->balance = this->balance - amount;
            cout << "Withdrawal successful. New balance: $" << this->balance << endl;
        } else {
            cout << "Insufficient balance. Current balance: $" << this->balance << endl;
        }
    }

    long GetBalance()
    {
        return this->balance;
    }

    long GetAccountNumber() const
    {
        return accountNumber;
    }

    static void GetAccounts()
    {
        cout << "Total accounts are: " << total << endl;
    }
};

long Account::AccNo = 1000000;
int Account::total = 0;

// Function to find an account by number
int findAccount(Account* accounts, int size, long accNumber) {
    for (int i = 0; i < size; i++) {
        if (accounts[i].GetAccountNumber() == accNumber) {
            return i;
        }
    }
    return -1; // Not found
}

// Function to display all accounts
void displayAllAccounts(Account* accounts, int count) {
    if (count == 0) {
        cout << "No accounts to display." << endl;
        return;
    }
    
    cout << "\n------ All Accounts ------" << endl;
    for (int i = 0; i < count; i++) {
        accounts[i].Display();
    }
    cout << "--------------------------" << endl;
}

int main() {
    const int MAX_ACCOUNTS = 100;
    Account* accounts = new Account[MAX_ACCOUNTS]; // Array of accounts without pointers
    Account** pAccounts = new Account*[MAX_ACCOUNTS]; // Array of pointers to accounts
    
    int accCount = 0;    // Counter for regular array
    int pAccCount = 0;   // Counter for pointer array
    int choice;
    long accNumber, amount;
    string name, addr;
    
    do {
        cout << "\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====" << endl;
        cout << "1. Open New Account (Without Pointer)" << endl;
        cout << "2. Open New Account (With Pointer)" << endl;
        cout << "3. Display All Accounts (Without Pointer)" << endl;
        cout << "4. Display All Accounts (With Pointer)" << endl;
        cout << "5. Find Account and Display Details" << endl;
        cout << "6. Deposit Money" << endl;
        cout << "7. Withdraw Money" << endl;
        cout << "8. Display Total Number of Accounts" << endl;
        cout << "0. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;
        
        switch (choice) {
            case 1: // Open account without pointer
                if (accCount < MAX_ACCOUNTS) {
                    cout << "\n----- Opening New Account (Without Pointer) -----" << endl;
                    accounts[accCount].Accept();
                    cout << "Account created successfully!" << endl;
                    accounts[accCount].Display();
                    accCount++;
                } else {
                    cout << "Maximum account limit reached!" << endl;
                }
                break;
                
            case 2: // Open account with pointer
                if (pAccCount < MAX_ACCOUNTS) {
                    cout << "\n----- Opening New Account (With Pointer) -----" << endl;
                    cout << "Enter name: ";
                    cin >> name;
                    cout << "Enter address: ";
                    cin >> addr;
                    cout << "Enter initial balance: ";
                    cin >> amount;
                    
                    pAccounts[pAccCount] = new Account(name, addr, amount);
                    cout << "Account created successfully!" << endl;
                    pAccounts[pAccCount]->Display();
                    pAccCount++;
                } else {
                    cout << "Maximum account limit reached!" << endl;
                }
                break;
                
            case 3: // Display all accounts (without pointer)
                cout << "\n----- Accounts (Without Pointer) -----" << endl;
                displayAllAccounts(accounts, accCount);
                break;
                
            case 4: // Display all accounts (with pointer)
                cout << "\n----- Accounts (With Pointer) -----" << endl;
                if (pAccCount == 0) {
                    cout << "No accounts to display." << endl;
                } else {
                    for (int i = 0; i < pAccCount; i++) {
                        pAccounts[i]->Display();
                    }
                }
                break;
                
            case 5: // Find account
                cout << "\nEnter account number to find: ";
                cin >> accNumber;
                
                // Search in regular array
                int index;
                index = findAccount(accounts, accCount, accNumber);
                if (index != -1) {
                    cout << "Account found (Without Pointer):" << endl;
                    accounts[index].Display();
                } else {
                    // Search in pointer array
                    bool found = false;
                    for (int i = 0; i < pAccCount; i++) {
                        if (pAccounts[i]->GetAccountNumber() == accNumber) {
                            cout << "Account found (With Pointer):" << endl;
                            pAccounts[i]->Display();
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                }
                break;
                
            case 6: // Deposit money
                cout << "\nEnter account number: ";
                cin >> accNumber;
                cout << "Enter amount to deposit: ";
                cin >> amount;
                
                // Search in regular array
                index = findAccount(accounts, accCount, accNumber);
                if (index != -1) {
                    accounts[index].SetDepositMoney(amount);
                } else {
                    // Search in pointer array
                    bool found = false;
                    for (int i = 0; i < pAccCount; i++) {
                        if (pAccounts[i]->GetAccountNumber() == accNumber) {
                            pAccounts[i]->SetDepositMoney(amount);
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                }
                break;
                
            case 7: // Withdraw money
                cout << "\nEnter account number: ";
                cin >> accNumber;
                cout << "Enter amount to withdraw: ";
                cin >> amount;
                
                // Search in regular array
                index = findAccount(accounts, accCount, accNumber);
                if (index != -1) {
                    accounts[index].SetWithdrawMoney(amount);
                } else {
                    // Search in pointer array
                    bool found = false;
                    for (int i = 0; i < pAccCount; i++) {
                        if (pAccounts[i]->GetAccountNumber() == accNumber) {
                            pAccounts[i]->SetWithdrawMoney(amount);
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                }
                break;
                
            case 8: // Display total accounts
                Account::GetAccounts();
                break;
                
            case 0: // Exit
                cout << "Exiting program..." << endl;
                break;
                
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
        
    } while (choice != 0);
    
    // Clean up dynamically allocated memory
    for (int i = 0; i < pAccCount; i++) {
        delete pAccounts[i];
    }
    delete[] pAccounts;
    delete[] accounts;
    
    return 0;
}