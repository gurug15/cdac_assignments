#include<iostream>
#include<cmath>
using namespace std;

void sidePyr(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<i+1;j++){
            cout<<"*";
        }
        cout<<endl;
    }
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            cout<<"*";
        }
        cout<<endl;
    }
}
void binaryPyr(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            if((i+j)%2==0){
                cout<<"1 ";
            }else{
                cout<<"0 ";
            }
        }
        cout<<endl;
    }
}
void numCrown(int n){
    for(int i=0; i<n;i++){
        for(int j=0;j<i+1;j++){
            cout<<j+1<<" ";
        }
        for(int j=n;j>i;j--){
            cout<<"  ";
        }
        for(int j=n;j>i;j--){
            cout<<"  ";
        }
        for(int j=0;j<i+1;j++){
            cout<<i-j+1<<" ";
        }
        cout<<endl;
    }
}
void NumberTriangle(int n){
   int k = 1;

    for(int i=0;i<n;i++){
        for(int j=0;j<i+1;j++){
            cout<<k<<" ";
            k++;
        }
        cout<<endl;
    }
}
void LetterTraingle(int n){
    

    for(int i=0;i<n;i++){
        char k = 'A';
        for(int j=0;j<i+1;j++){
            cout<<k<<" ";
            k++;
        }
        cout<<endl;
    }
}
void RevLetterTraingle(int n){
    

    for(int i=0;i<n;i++){
        char k = 'A';
        for(int j=n;j>i;j--){
            cout<<k<<" ";
            k++;
        }
        cout<<endl;
    }
}

void alphaRamp(int n){
    char k = 'A';
    for(int i=0;i<n;i++){
        
        for(int j=0;j<i+1;j++){
            cout<<k<<" ";
            
        }
        k++;
        cout<<endl;
    }
}
void alphaHill(int n){
    for(int i=0;i<n;i++){
        for(int j=n;j>i+1;j--){
          cout<<"  ";
        }
        char k= 'A';
        for(int j=0;j<i+1;j++){
            cout<<k<<" ";
            k++;
        }
        k=i+'A'-1;
        for(int j=0;j<i;j++){
            cout<<k<<" ";
            k--;
        }
        cout<<endl;
    }
}

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

void ButterFly(int n){
    int spaces = 2*n-2;
    for(int i=1;i<=2*n-1;i++){
        int stars = i;
        if(i>n){
            stars=2*n-i;   
          }
        for(int j=0;j<stars;j++){
            cout<<"* ";
        } 
        for(int j=0;j<spaces;j++){
            cout<<"  ";
        }
        for(int j=0;j<stars;j++){
            cout<<"* ";
        }
        if(i<n){
            spaces = spaces-2;
        }else{
            spaces = spaces+2;
        }
       cout<<endl;
    }
}

void getStarPattern(int n) {
    // Write your code here.
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==0||j==0||i==n-1||j==n-1){
                cout<<"*";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
}

void getNumberPattern(int n) {
    // Write your code here.
    for(int i=0;i<2*n-1;i++){
        for(int j=0;j<2*n-1;j++){
            int top = i;
            int left = j;
            int right = 2*n-2-j;
            int bottom = 2*n-2-i;
            cout<<(n-min(min(top,bottom),min(left,right)));
        }
        cout<<endl;
    }
}




int main(){
   
    //sidePyr(3);
    //binaryPyr(3);
    //numCrown(3);
    //NumberTriangle(3);
    //LetterTraingle(3);
    //RevLetterTraingle(3);
    //alphaRamp(3);
    //alphaHill(3);
    //hollowDiamond(5);
    //ButterFly(3);
    getNumberPattern(3);
    return 0;

}