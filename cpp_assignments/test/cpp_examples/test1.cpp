#include<iostream>
#include <limits>
using namespace std;
int main()
{
 cout<<"sizeof int: "<<sizeof(int);
 cout << "int ranges from: " << numeric_limits<int>::min()
         << " to " << numeric_limits<int>::max() << endl;


 cout<<"sizeof unsigned int: "<<sizeof(unsigned int);
 cout << "unsigned int ranges from: " << numeric_limits<unsigned int>::min()
         << " to " << numeric_limits<unsigned int>::max() << endl;


 cout<<"sizeof long int: "<<sizeof(long int);
 cout << "long int ranges from: " << numeric_limits<long int>::min()
         << " to " << numeric_limits<long int>::max() << endl;


 cout<<"sizeof unsigned long int: "<<sizeof(unsigned long int);
 cout << "unsigned long int ranges from: " << numeric_limits<unsigned long int>::min()
         << " to " << numeric_limits<unsigned long int>::max() << endl;


 cout<<"sizeof long long int: "<<sizeof(long long int);
 cout << "long long int ranges from: " << numeric_limits<long long int>::min()
         << " to " << numeric_limits<long long int>::max() << endl;


 cout<<"sizeof unsigned long long int: "<<sizeof(unsigned long long int);
 cout << "unsigned long long int ranges from: " << numeric_limits<unsigned long long int>
 ::min()<< " to " << numeric_limits<unsigned long long int>::max() << endl;


 cout<<"sizeof short int: "<<sizeof(short int);
 cout << "short int ranges from: " << numeric_limits<short int>::min()
         << " to " << numeric_limits<short int>::max() << endl;


 cout<<"sizeof unsigned short int: "<<sizeof(unsigned short int);
 cout << "unsigned short int ranges from: " << numeric_limits<unsigned short int>::min()
         << " to " << numeric_limits<unsigned short int>::max() << endl;


 cout<<"sizeof char: "<<sizeof(char);
 cout << "char ranges from: " << numeric_limits<char>::min()
         << " to " << numeric_limits<char>::max() << endl;


 cout<<"sizeof unsigned char: "<<sizeof(unsigned char);
 cout << "unsigned char ranges from: " << numeric_limits<unsigned char>::min()
         << " to " << numeric_limits<unsigned char>::max() << endl;


 cout<<"sizeof float: "<<sizeof(float);
 cout << "float ranges from: " << numeric_limits<float>::min()
         << " to " << numeric_limits<float>::max() << endl;



 cout<<"sizeof double: "<<sizeof(double);
 cout << "double ranges from: " << numeric_limits<double>::min()
         << " to " << numeric_limits<double>::max() << endl;


return 0;
}
