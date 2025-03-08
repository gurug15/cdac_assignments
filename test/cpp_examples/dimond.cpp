#include<iostream>
using namespace std;

void erect_pyd(int n){
    
    for (int i = 0; i < n; i++) {
        // Print spaces
        for (int j = 0; j < n - i - 1; j++) {
            cout << " ";
        }
        // Print stars (left part)
        for (int j = 0; j < i + 1; j++) {
            cout << "*";
        }
        // Print stars (right part)
        for (int j = 0; j < i; j++) {
            cout << "*";
        }
        cout << endl;
    }


}
void invert_pyd(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
          cout<<" ";
        }
        for(int j=n-i-1;j>0;j--){
            cout<<"*";
        }
        for(int j=n-i-2;j>0;j--){
            cout<<"*";
        }
        cout<<endl;
    }
    
}

int main(){
    int num = 3;
    erect_pyd(num);
    invert_pyd(num);
    return 0;
}