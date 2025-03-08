#include<iostream>
using namespace std;

long long int_to_binary(int num){
    long long binary = 0;
    int place =1;
    while(num>0){
        int reminder = num%2;
        binary = binary + reminder*place;
        place = place*10;
        num = num/2;
    }
    return binary;
}

// long long recur_binary(int num){
    
// }

int main(){
    int num;
    cout<<"enter num: ";
    cin>>num;
    cout<<"binary number is:"<<int_to_binary(num)<<endl;

    return 0;
}