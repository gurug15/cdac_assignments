#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

// Base class Product
class Product {
public:
    int id;
    string name;
    double price;

    Product(int id = 0, string name = "", double price = 0.0) : id(id), name(name), price(price) {}

    virtual void display() {
        cout << "ID: " << id << ", Name: " << name << ", Price: $" << price;
    }

    virtual string getType() {
        return "Product";
    }
};

// Derived class Book
class Book : public Product {
public:
    string author;

    Book(int id = 0, string name = "", double price = 0.0, string author = "")
        : Product(id, name, price), author(author) {}

    void display() override {
        Product::display();
        cout << ", Author: " << author;
    }

    string getType() override {
        return "Book";
    }
};

// Derived class WristWatch
class WristWatch : public Product {
public:
    string type; // "analog" or "smart"

    WristWatch(int id = 0, string name = "", double price = 0.0, string type = "")
        : Product(id, name, price), type(type) {}

    void display() override {
        Product::display();
        cout << ", Type: " << type;
    }

    string getType() override {
        return "WristWatch";
    }
};

// Function to load books from file
vector<Book> loadBooksFromFile(const string& filename) {
    vector<Book> books;
    ifstream file(filename);
    if (file.is_open()) {
        int id;
        string name, author;
        double price;
        while (file >> id >> name >> price >> author) {
            books.emplace_back(id, name, price, author);
        }
        file.close();
    }
    return books;
}

// Function to save books to file
void saveBooksToFile(const vector<Book>& books, const string& filename) {
    ofstream file(filename);
    if (file.is_open()) {
        for (const auto& book : books) {
            file << book.id << " " << book.name << " " << book.price << " " << book.author << endl;
        }
        file.close();
    }
}

// Function to load watches from file
vector<WristWatch> loadWatchesFromFile(const string& filename) {
    vector<WristWatch> watches;
    ifstream file(filename);
    if (file.is_open()) {
        int id;
        string name, type;
        double price;
        while (file >> id >> name >> price >> type) {
            watches.emplace_back(id, name, price, type);
        }
        file.close();
    }
    return watches;
}

// Function to save watches to file
void saveWatchesToFile(const vector<WristWatch>& watches, const string& filename) {
    ofstream file(filename);
    if (file.is_open()) {
        for (const auto& watch : watches) {
            file << watch.id << " " << watch.name << " " << watch.price << " " << watch.type << endl;
        }
        file.close();
    }
}

int main() {
    vector<Book> books = loadBooksFromFile("books.txt");
    vector<WristWatch> watches = loadWatchesFromFile("watches.txt");
    vector<Product*> cart; // Container for purchased products

    int choice;
    do {
        cout << "\nProduct Management System" << endl;
        cout << "1) Add a Book" << endl;
        cout << "2) Add a Watch" << endl;
        cout << "3) Purchase Product" << endl;
        cout << "4) Generate Bill" << endl;
        cout << "5) Exit" << endl;
        cout << "6) Display all Books" << endl;
        cout << "7) Display all WristWatches" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: { // Add a Book
                int id;
                string name, author;
                double price;
                cout << "Enter Book ID: ";
                cin >> id;
                cout << "Enter Book Name: ";
                cin.ignore();
                getline(cin, name);
                cout << "Enter Book Price: ";
                cin >> price;
                cout << "Enter Author Name: ";
                cin.ignore();
                getline(cin, author);
                books.emplace_back(id, name, price, author);
                saveBooksToFile(books, "books.txt");
                cout << "Book added successfully!" << endl;
                break;
            }
            case 2: { // Add a Watch
                int id;
                string name, type;
                double price;
                cout << "Enter Watch ID: ";
                cin >> id;
                cout << "Enter Watch Name: ";
                cin.ignore();
                getline(cin, name);
                cout << "Enter Watch Price: ";
                cin >> price;
                cout << "Enter Watch Type (analog/smart): ";
                cin >> type;
                watches.emplace_back(id, name, price, type);
                saveWatchesToFile(watches, "watches.txt");
                cout << "Watch added successfully!" << endl;
                break;
            }
            case 3: { // Purchase Product
                int productId;
                cout << "Enter Product ID to purchase: ";
                cin >> productId;

                // Search in books
                for (auto& book : books) {
                    if (book.id == productId) {
                        cart.push_back(new Book(book));
                        cout << "Book added to cart!" << endl;
                        break;
                    }
                }

                // Search in watches
                for (auto& watch : watches) {
                    if (watch.id == productId) {
                        cart.push_back(new WristWatch(watch));
                        cout << "Watch added to cart!" << endl;
                        break;
                    }
                }
                break;
            }
            case 4: { // Generate Bill
                double total = 0.0;
                cout << "\n--- Bill ---" << endl;
                for (const auto& product : cart) {
                    product->display();
                    cout << endl;
                    total += product->price;
                }
                cout << "Total: $" << total << endl;

                // Clear the cart after generating bill
                for (auto& product : cart) {
                    delete product; // Free memory
                }
                cart.clear();
                break;
            }
            case 5: { // Exit
                cout << "Exiting..." << endl;
                break;
            }
            case 6: { // Display all Books
                cout << "\n--- Books ---" << endl;
                for (const auto& book : books) {
                    book.display();
                    cout << endl;
                }
                break;
            }
            case 7: { // Display all WristWatches
                cout << "\n--- WristWatches ---" << endl;
                for (const auto& watch : watches) {
                    watch.display();
                    cout << endl;
                }
                break;
            }
            default:
                cout << "Invalid choice!" << endl;
        }
    } while (choice != 5);

    return 0;
}