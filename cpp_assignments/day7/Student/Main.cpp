#include<iostream>
#include<cstring>
#include"Student.h"
using namespace std;


void AcceptMultiple(Student *s,int size){
    for(int i=0;i<size;i++){
        cout<<"Enter "<<i+1<<"st student: ";
        (s+i)->Accept();
    }
}
void DisplayMultiple(Student *s,int size){
    cout<<"rollNo\tname\temail\t\tmarks\tclg\tmemoryadr"<<endl;
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