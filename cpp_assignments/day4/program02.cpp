#include<iostream>
#include<climits>
using namespace std;


int maxi(int * arr, int n){
        int max = arr[n-1];
        for(int i=0;i<n;i++){
                if(max<=arr[i]){
                        max = arr[i];
                }
        }
   return max;
}

int mini(int * arr, int n){
	int min = arr[0];
	for(int i=0;i<n;i++){
		if(min>=arr[i]){
			min =arr[i];
		}
	}
      return min;
}
int submin(int * arr, int n,int *minimum){
        int *min = minimum;
        int submin = INT_MAX;
        for(int i=0;i<n;i++){
                if(submin>arr[i] && *min<arr[i] ){
                        //submin = min;
                        submin =arr[i];
                }
		
        }
	if(submin== INT_MAX){
		submin = *min;
	}
       return submin;
}
int submax(int * arr, int n, int *maximum){
        int *max = maximum; 
	int submax = 0;
        for(int i=0;i<n;i++){
		
                if(submax<arr[i] && *max>arr[i]){
			submax = arr[i];
                }

         }
	if(submax == INT_MIN){
		submax = *max;
	}
	return submax;
}
/*
void minmax(int * arr, int n){
        int min = arr[0];
        int max = arr[n-1];
        int submin = 0;
        int submax =0;
        for(int i=0;i<n;i++){
                if(max<=arr[i]){
                        submax = max;
                        max = arr[i];
                }
                if(min>=arr[i]){
                        submin= min;
                        min =arr[i];
                }
        }
        cout<<"min: "<<min<<endl;
        cout<<"submin: "<<submin<<endl;
        cout<<"submax: "<<submax<<endl;
        cout<<"max: "<<max<<endl;

}
*/

int main(){
      int n;
      cout<<"Enter a number: ";
      cin>>n;
      int arr[n];
      cout<<"enter a num: "<<endl;
      for(int i=0;i<n;i++){
	     cin>>arr[i];
      }
      int min = mini(arr,n);
      int max = maxi(arr,n);
      cout<<"Min: " <<min<<endl;
      cout<<"SubMin: " <<submin(arr,n,&min)<<endl;
      cout<<"Max: " <<max<<endl;
      cout<<"SubMax: " <<submax(arr,n,&max)<<endl;
      //minmax(arr,n);
            

	return 0;
}
