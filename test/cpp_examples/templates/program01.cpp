#include<iostream>
using namespace std;
template<class T>
void Swap(T &a,T&b){
    T temp = a;
    a=b;
    b=temp;
}
template<class T>
T Add(T a, T b)
{
   return a+b;
}
template<class T>
T Sub(T a, T b)
{
   return a-b;
}
template<class T>
T Mul(T a, T b)
{
   return a*b;
}
template<class T>
T Div(T a, T b)
{
   return a/b;
}

int main()
{
    int a = 10, b = 30;
    float c=20.20,d=30.03;
    char e='Z',f='A';

    Swap(a,b);
    cout<<"\nfirst:"<<a<<"sec<"<<b;
    
    Swap(c,d);
    cout<<"\nfirst:"<<c<<"sec<"<<d;
    
    Swap(e,f);
    cout<<"\nfirst:"<<e<<"sec<"<<f<<endl;
    
    cout<<Add(a,b)<<endl;
    
    cout<<Add(c,d)<<endl;
    cout<<Add(e,f)<<endl;
    cout<<Sub(a,b)<<endl;

    return 0;
}