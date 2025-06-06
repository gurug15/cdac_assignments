#include<iostream>
#include<string>
#include<exception>
using namespace std;

class Person {
    int age;
    string name;
    public:
        Person(){};
        Person(int age,string name): age(age), name(name){}
    void accept(){
        cout<<"enter age";
        cin>>this->age;
        cout<<"enter name";
        cin>>this->name;
    }
    void display() const {
        cout<< this->age;
        cout<< this->name;

        
    }
};


class MyException{
    string message;
    public:
    MyException(string msg): message(msg) {}
    string getMess() const{
        return this->message;
    }
};

int abc(){
    throw MyException("Bahi kitna error dega");
}


int main(){
    

    try
    {
        abc();
    }
    catch(const int e)
    {
        std::cerr << e << '\n';
    }
    catch(const MyException e)
    {
        std::cerr << e.getMess() << '\n';
    }
    catch(...){
        cout<<"got some fucking error";
    }
    
    

    return 0;
}

