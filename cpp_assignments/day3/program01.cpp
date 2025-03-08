#include <iostream>
using namespace std;

void pattern1(int N)
{
    
    for (int i = 0; i < N; i++)
    {
        for (int j =N; j>i; j--)
        {
            cout <<"* ";
        }
        cout << endl;
    }
}

int main()
{   
    int N = 5;

    pattern1(N);

    return 0;
}