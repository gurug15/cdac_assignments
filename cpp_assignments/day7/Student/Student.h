
class Student {
    private:
    int rollNo;
    char name[50];
    char email[50];
    int marks;
    const char clg[50];
    static int count;

    public:
    Student();
    Student(const int rollNo, const char *name, const char  *email,const int marks);
    void Accept();
    void Display();
    static int GetCount();
};
