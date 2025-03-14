#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int main(int argCount, char *argVariables[])
{
    if(argCount<3){
        cout<<"Give all args \n Usage cpy SRC DST";
        return -1;
    }

    ifstream fin(argVariables[1]);
    ofstream fout(argVariables[2]);

    if(!fin)
	{
	cout<<"\n Unable to open file in read mode"<<endl;
	return -1;
	}

	if(!fout)
	{
	cout<<"\n Unable to open file in write mode"<<endl;
	return -1;
	}

    // string str;
    // while(fin){
    //     //coping/reading conternt from file using fin and writing it to str;
    //     getline(fin,str);
    //     fout<<str;

    // }

    char c;
    while(fin)
    {
        fin.get(c);
        fout<<c;
    }

    fin.close();
    fout.close();
    return 0;
}