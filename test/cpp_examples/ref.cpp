#include<iostream>
using namespace std;


int main(){
    const &r = 12;
    int a =10;
    const &k =a;
    
    a++;
    //r++;
    cout<<a<<" "<<r<<" "<<k;

    return 0;
}