#include<iostream>
#include<string>
using namespace std;

struct Student {
	private:
		int rollNo;
		string name;
        public:
		void Accept(){
			cout<<"Enter rollNO, name:"<<endl;
			cin>>this->rollNo;
			cin>>this->name;
		}

		void Display(){
			cout<<this->rollNo<<" ";
			cout<<this->name<<" ";
		}

		long getrollNo(){
			return this->rollNo;
		}

};

void swap(Student * a, Student * b){
	Student temp = *a;
	*a = *b;
	*b =  temp;
}

void sort(Student stu[],int n){
	for(int i=0;i<n;i++){
		for(int j=0;j<n-i-1;j++){
			if(stu[j].getrollNo()>stu[j+1].getrollNo()){
				swap(stu[j],stu[j+1]);
			}
		}
	}
}
void InputArray(Student One[],int n){
     
     for(int i=0;i<n;i++){
	     cout<<i+1<<" element enter:";
	     One[i].Accept();
     }

}

void PrintArray(Student One[],int n){
     
     for(int i=0;i<n;i++){
	     One[i].Display();
     }

}



int main(){
      int n;
      Student *stu = new Student[n];
      cout<<"enter array size: ";
      cin>>n;
      
      InputArray(stu,n);
      sort(stu,n);
      PrintArray(stu,n);

      return 0;
}

