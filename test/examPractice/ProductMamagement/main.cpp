#include<iostream>
#include<vector>
#include<fstream>
#include"classes.cpp"
using namespace std;

vector<Product*> books;
vector<Product*> watches;
vector<Product*> allProd;
vector<Product*> cart;

void updateAllProducts() {
    allProd.clear();
    allProd.insert(allProd.end(), books.begin(), books.end());
    allProd.insert(allProd.end(), watches.begin(), watches.end());
}

void saveBooksToFile() {
    ofstream outFile("books.dat", ios::binary | ios::out);
    if (!outFile) {
        cout << "Error opening books.dat for writing." << endl;
        return;
    }
    for (auto &book : books) {
        outFile.write(reinterpret_cast<char*>(book), sizeof(Book));
    }
    outFile.close();
}

void saveWatchesToFile() {
    ofstream outFile("watches.dat", ios::binary | ios::out);
    if (!outFile) {
        cout << "Error opening watches.dat for writing." << endl;
        return;
    }
    for (auto &watch : watches) {
        outFile.write(reinterpret_cast<char*>(watch), sizeof(Watch));
    }
    outFile.close();
}

void loadBooksFromFile() {
    ifstream inFile("books.dat", ios::binary | ios::in);
    if (!inFile) {
        cout << "No books found in storage." << endl;
        return;
    }
    while (!inFile.eof()) {
        Book *book = new Book();
        inFile.read(reinterpret_cast<char*>(book), sizeof(Book));
        if (inFile.gcount() == sizeof(Book)) {
            books.push_back(book);
        } else {
            delete book;
        }
    }
    inFile.close();
    updateAllProducts();
}

void loadWatchesFromFile() {
    ifstream inFile("watches.dat", ios::binary | ios::in);
    if (!inFile) {
        cout << "No watches found in storage." << endl;
        return;
    }
    while (!inFile.eof()) {
        Watch *watch = new Watch();
        inFile.read(reinterpret_cast<char*>(watch), sizeof(Watch));
        if (inFile.gcount() == sizeof(Watch)) {
            watches.push_back(watch);
        } else {
            delete watch;
        }
    }
    inFile.close();
    updateAllProducts();
}



void addBook()
{
	int id;
	char name[30];
	char author[30];
	float price;
	cout<<"Enter Book Details"<<endl;
	cout<<"Enter Id: ";
	cin>>id;
	cin.ignore();
	cout<<"Enter name: ";
	cin.getline(name,30);
	cout<<"Enter Author: ";
	cin.getline(author,30);
	cout<<"Enter price: ";
	cin>>price;
	books.push_back(new Book(id,name,price,author));
	updateAllProducts();
	cout<<"Book Added Succesfully"<<endl;
}
void addWatch()
{
	int id;
	char name[30];
	char type[30];
	float price;
	cout<<"Enter Book Details"<<endl;
	cout<<"Enter Id: ";
	cin>>id;
	cin.ignore();
	cout<<"Enter name: ";
	cin.getline(name,30);
	cout<<"Enter Type as Analog or Smart: ";
	cin.getline(type,30);
	cout<<"Enter price: ";
	cin>>price;
	watches.push_back(new Watch(id,name,price,type));
	updateAllProducts();
	cout<<"Watch Added Succesfully"<<endl;
}


void purchaseProd(){
	int choice;
	cout<<"Products are"<<endl;
	for(int i=0;i<allProd.size();i++){
		cout<<"press "<<i+1<<" for ";
		allProd[i]->display();
	}
	while(true)
	{
		cout << "Enter product number to add to cart (0 to stop): ";
        cin >> choice;
        if (choice == 0) return;
        if (choice > 0 && choice <= allProd.size()) {
            cart.push_back(allProd[choice - 1]);
            cout << "Product added to cart." << endl;
        } else {
            cout << "Invalid choice, try again." << endl;
        }
	}
	cout << "Finished adding products to cart." << endl;
}

void generateBill()
{
	if (cart.empty()) {
        cout << "Cart is empty. No bill to generate." << endl;
        return;
    }
    
    float total = 0;
    cout << "\n----- BILL -----\n";
    for (auto &item : cart) {
        item->display();
        total += item->getPrice(); // getPrice function needs to be added to Product class
    }
    cout << "Total Amount: Rs. " << total << endl;
    cout << "------------------\n";
    cart.clear();
	
}
	


void DisplayBooks(){
	for(auto &book: books)
	{
		book->display();
	}
}
void DisplayWatches(){
	for(auto &watch: watches)
	{
		watch->display();
	}
}


void loadData() {
    loadBooksFromFile();
    loadWatchesFromFile();
}




void mainMenu(){
	int choice;
	while(true)
	{
		cout<<"Product Management Sysetem"<<endl;
		cout<<"Choose options"<<endl;
		cout<<"1.- to Add Books"<<endl;
		cout<<"2.- to Add Watch"<<endl;
		cout<<"3.- Purchase Produt"<<endl;
		cout<<"4.- Generate bill"<<endl;
		cout<<"5.- Display All Books"<<endl;
		cout<<"6.- Display All Watches"<<endl;
		cout<<"7.- Exit"<<endl;
		cout<<"Enter Your Choice: ";
		cin>>choice;
		switch(choice){
			case 1: addBook(); saveBooksToFile(); break;
			case 2: addWatch(); saveWatchesToFile(); break;
			case 3: purchaseProd(); break;
			case 4: generateBill();break;
			case 5: DisplayBooks(); break;
			case 6: DisplayWatches(); break;
			case 7: cout<<"Exiting....."<<endl;
				return;
			default:cout<<"Invalid input Terminating Program\n";
				return;
	
		}
	}


}

int main()
{	
	loadData();
	mainMenu();
	return 0;
}
