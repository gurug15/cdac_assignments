#include<string>
using namespace std;
class Employee{
    private:
    int empNo;
    string name;
    long salary;
    string department;

    public:
    void Accept();
    void Display();
    long getSalary();
    int getEmployeeId();

};