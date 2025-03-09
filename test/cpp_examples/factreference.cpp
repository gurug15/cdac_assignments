#include<iostream>
using namespace std;



int Fact(const int &n){
    int fact=1;
    //n=10
    for(int i=1;i<=n;i++){
        fact = fact * i;
    }
    return fact;
}

int main(){
    int num;
    cout<<"enter a num: ";
    cin>>num;


    cout<<Fact(num);


    return 0;
}