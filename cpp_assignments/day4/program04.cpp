#include<iostream>
using namespace std;


void swap(char &a, char &b){
   int temp = a;
   a=b;
   b=temp;
}



void reverse(char *arr, int s, int e){
        while(s<e){

        swap(arr[s], arr[e]);

        s++;
        e--;
        }
}


int charLength(const char *arr){
      int count = 0;
      while(arr[count] != '\0'){

              count++;
      }

      return count;
}

int main(){
        char arr[100];
/*      for(int i=0;i<size;i++){
                cout<<"enter "<<i+1<<" elelmet";
                cin>>arr[i];
        }
*/      
        cin>>arr;
        int size = charLength(arr);
        reverse(arr,0,size-1);
        cout<<"the reverse strinf is:";
                cout<<arr<<endl;
        return 0;
}
