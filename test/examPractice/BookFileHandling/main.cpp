#include<iostream>
#include"book.cpp"
#include<fstream>
#include<vector>
using namespace std;

const string fileName = "Books.dat";
void addBook();
void displayBooks();
void displaySorted();
void displaySpecific(int);


int main(){
	int choice = -1;
	while(choice != 5)
	{
		cout << "\n1. Add Book Details";
        	cout << "\n2. Display All Books";
        	cout << "\n3. Display Sorted Books (by Price)";
        	cout << "\n4. Get Single Book";
        	cout << "\n5. Exit";
        	cout << "\nEnter your choice: ";
        	cin >> choice;

		switch (choice) {
            	case 1:
                	addBook();
                	break;
            	case 2:
                	displayBooks();
                	break;
            	case 3:
                	displaySorted();
                	break;
            	case 4:
			int bookId;
			cout<<"Enter Book ID: ";
			cin>>bookId;
                	displaySpecific(bookId);
                	break;
            	case 5:
                	cout << "Exiting..." << endl;
                	break;
            	default:
                	cout << "Invalid choice! Try again." << endl;
			return 0;
        	}
	}	

	return 0;
}

void addBook(){
	fstream fout(fileName,ios::app | ios::binary);
	if(!fout){
		cout<<"Error opening file"<<endl;
		return;
	}

	Book book;
	book.Accept();
	book.write(fout);
	fout.close();
	cout<<"Book details have been added Succesfully\n";
	book.Display();
}


void displayBooks(){
	ifstream fin(fileName,ios::binary);
	if(!fin){
		cout<<"Cannot read this file"<<endl;
		return;
	}

	Book book;
	cout<<"-----All Books----"<<endl;
	while(fin.read((char*)&book, sizeof(Book))){
		book.Display();
	}
	fin.close();
}
void displaySorted(){
	ifstream fin(fileName,ios::binary);
	if(!fin){
		cout<<"Cannot read the file"<<endl;
		return;
	}

	vector<Book> books;
	Book book;
	while(fin.read((char*)&book,sizeof(Book))){
		books.push_back(book);
	}
	fin.close();

	for(int i=0;i<books.size();i++){
		Book temp;
		for(int j=0;j<books.size()-i-1;j++){
			if(books[j].getPrice()>books[j+1].getPrice()){
				temp = books[j];
				books[j] = books[j+1];
				books[j+1] = temp;
			}
		}
	}
	vector<Book>::iterator it = books.begin();
	for(;it!=books.end();it++){
		it->Display();
	}

}

void displaySpecific(int id){
	ifstream fin(fileName,ios::binary);
	if(!fin){
		cout<<"Cannot read the file"<<endl;
		return;
	}
	Book book;
	while(fin.read((char*)&book,sizeof(Book))){
		if(book.getBookId() == id){
			book.Display();
			return;
		}
	}
	cout<<"Book Not Found\n";

	}
