#include<iostream>
using namespace std; 
// class BixBase
// {
//     int x, y; 
//     public:
//     BixBase(int xx = 10, int yy = 10)
//     {
//         x = xx;
//         y = yy;
//     }
//     void Show()
//     {
//         cout<< x * y << endl;
//     }
// };
// class BixDerived
// {
//     private:
//         BixBase objBase; 
//     public:
//     BixDerived(int xx, int yy) : objBase(xx, yy)
//     {
//         objBase.Show();
//     }
// };
// int main()
// {
//     BixDerived objDev(10, 20);
//     return 0; 
// }

class Base
{
    public:
    int S, A, M; 
    Base(int x, int y)
    {
        S = y - y;
        A = x + x; 
        M = x * x;
    }
    Base(int, int y = 'A', int z = 'B')
    {
        S = y;
        A = y + 1 - 1; 
        M = z - 1;
    }
    void Display(void)
    {
        cout<< S << " " << A << " " << M << endl;
    }
};
class Derived : public Base
{
    int x, y, z; 
    public:
    Derived(int xx = 65, int yy = 66, int zz = 67): Base(x)
    {
        x = xx; 
        y = yy;
        z = zz;
    }
    void Display(int n)
    {
        if(n)
            Base::Display(); 
        else
            cout<< x << " " << y << " " << z << endl; 
    }
};
int main()
{
    // Derived objDev; 
    // objDev.Display(-1); 



    // int a = 10, b = 20 , c=30;
    // int *arr[]  = {&a,&b,&c};
    // cout<<*arr[0];

    // return 0;
    int x = 10, y = 20;
    int *ptr = &x;
    int &ref = y;

    *ptr++;
     ref++;    

    cout<< x << " " << y;
    return 0;
}