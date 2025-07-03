#include<iostream>
#include<string>
using namespace std;

int anyfunc(){
    
    static string name = "abx";
    name = "aadsa";
    // char name[40] = "jaaaaaaba";
    // name = "asadsd";
    cout<<name;
    return 1;
}

int main(){
   int arr[3]={1,2,3};
    int *p1 =&arr[0];
    int *p2 = &arr[2];
    int locations = p2-p1;
    cout<<locations;

    return 0;
}