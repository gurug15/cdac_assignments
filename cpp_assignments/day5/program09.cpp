#include<iostream>

using namespace std;


struct Student
{
  int roll;
  char name[50];
};


void accept( Student *stu,int n)
{
	for(int i=0; i<n;i++){
		cout<<"Enter student "<<i+1<<"data:";
		cin>>stu->roll; //(*stu).roll
		cin>>stu->name;
	        cout<<"this is stu:  "<<stu<<endl;
	        stu++;
	}

}

void display(Student stu[], int n){
	for(int i=0;i<n;i++){
		cout<<stu[i].roll<<" ";
		cout<<stu[i].name<<endl;
	}
}


int main()
{
    int n;
    cout<<"enter no of students:";
    cin>>n;
    Student *stu=new Student[n];
    accept(stu,n);
    display(stu,n);
    return 0;

}
