#include<iostream>
using namespace std;

void CheckChar(char c){
  int charcase = int(c);

  if(charcase>=65 && charcase<=90){
	  cout<<"character "<<c<<" is uppercase"<<endl;
  }else if(charcase>=97 && charcase<=122){
	  cout<<"character "<<c<<" is lowercase"<<endl;
  }else{
	  cout<<"its not an character"<<endl;
  }
}



int main(){

   char c;
   cout<<"eneter a character: ";
   cin>>c;
   CheckChar(c);
   return 0;

}
