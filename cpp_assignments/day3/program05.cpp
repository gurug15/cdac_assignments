#include <bits/stdc++.h>
using namespace std;

void pattern5(int N)
{
      int num =1;
      
      for(int i=1;i<=N;i++){
          for(int j=1;j<=i;j++){
              cout<<num<<" ";
              num =num+1;
          }
          cout<<endl;
          
      }
}

int main()
{   
    int N = 5;
    pattern5(N);

    return 0;
}