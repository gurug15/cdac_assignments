#include<iostream>
using namespace std;

int fun(const int &num)
{
	if(num<=1)
	{
		return 1;
	}
	int temp = num -1; //Did this because i cant change the num as its a const referance;
	return num * fun(temp);
       	//cout<<num;
 

}


int main()
{
	int n;

	cin>>n;

	cout<<fun(n)<<endl;
}
