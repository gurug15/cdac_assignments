#include<iostream>
using namespace std;

void hollowDiamond(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i;j++){
            cout<<"* ";
        }
        for(int j=0;j<i*2;j++){
           cout<<"  ";
        }
        for(int j=0;j<n-i;j++){
            cout<<"* ";
        }
        cout<<endl; 
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<i+1;j++){
            cout<<"* ";
        }
        for(int j=0;j<(n-i-1)*2;j++){
            cout<<"  ";
        }
        for(int j=0;j<i+1;j++){
            cout<<"* ";
        }
        cout<<endl;
    }
}

int main(){
    int N = 5;
    hollowDiamond(N);

}