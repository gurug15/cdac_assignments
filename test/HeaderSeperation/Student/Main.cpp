#include<iostream>
#include<cstring>
using namespace std;

class Student {
    private:
    int rollNo;
    char name[50];
    char email[50];
    int marks;
    const char clg[50];
    static int count;

    public:
    Student(): rollNo(0), marks(0), clg("CDAC")
    {   
        strcpy(this->name, "N/A");
        strcpy(this->email, "N/A");
        count++;
    }
    Student(const int rollNo, const char *name, const char  *email,const int marks): clg("CDAC") 
    {
        this->rollNo = rollNo;
        strcpy(this->name ,name);
        strcpy(this->email, email);
        this->marks = marks;
        count++;
    }
    void Accept()
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

    void Display()
    {
       cout<<this->rollNo<<"\t";
       cout<<this->name<<"\t";
       cout<<this->email<<"\t";
       cout<<this->marks<<"\t";
       cout<<this->clg<<"\t";
       cout<<this<<endl;
    }

    static int GetCount()
    {
        return count;
    }
};

int Student::count=0;

void AcceptMultiple(Student *s,int size){
    for(int i=0;i<size;i++){
        cout<<"Enter "<<i+1<<"st student: ";
        (s+i)->Accept();
    }
}
void DisplayMultiple(Student *s,int size){
    cout<<"rollNo\tname\temail\tmarks\tclg\tmemoryadr"<<endl;
    for(int i=0;i<size;i++){
        s[i].Display();//s[i].Display();   //(s+i)->Display(); (*s+i).Display();
    }
}


int main(){
    int size;
    cout<<"enter no of students:";
    cin>>size;
    Student *Stu = new Student[size];
    AcceptMultiple(Stu,size);
    DisplayMultiple(Stu,size);
    cout<<"Count is: : "<<Student::GetCount()<<endl;
    cout<<sizeof(Student);

    delete []Stu;
}