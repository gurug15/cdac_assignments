#include<iostream>
#include<vector>
using namespace std;

class One
{
	private:
	 	int a;
	public:
		One():a(0) {}
		One(int a):a(a) {}
		void  Display()
		{
		cout<<"a is: "<<a<<endl;
		}
};

int main()
{
	vector <One> v1;
	// cout<<v1.begin()<<endl;
	v1.push_back(One(10));
	v1.push_back(One(12));
	v1.push_back(One(11));


	vector<One>::iterator it = v1.begin();
	for(it; it!=v1.end();it++)
	{
		it->Display();
	}
	return 0;
}
