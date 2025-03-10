    #include<iostream>
    #include<cstring>
    #include"Student.h"
    using namespace std;
    
    Student::Student(): rollNo(0), marks(0), clg("CDAC")
    {   
        strcpy(this->name, "N/A");
        strcpy(this->email, "N/A");
        count++;
    }
    Student::Student(const int rollNo, const char *name, const char  *email,const int marks): clg("CDAC") 
    {
        this->rollNo = rollNo;
        strcpy(this->name ,name);
        strcpy(this->email, email);
        this->marks = marks;
        count++;
    }
    void Student::Accept()
    {
        cout<<"\nenter name:";
        cin>>this->name;
        cout<<"\nenter rollNo:";
        cin>>this->rollNo;
        cout<<"\nenter email:";
        cin>>this->email;
        cout<<"\nenter marks:";
        cin>>this->marks;
    }

    void Student::Display()
    {
       cout<<this->rollNo<<"\t";
       cout<<this->name<<"\t";
       cout<<this->email<<"\t\t";
       cout<<this->marks<<"\t";
       cout<<this->clg<<"\t";
       cout<<this<<endl;
    }

    int Student::GetCount()
    {
        return count;
    }


    int Student::count=0;