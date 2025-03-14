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

    ifstream fin(argVariables[1],ios::binary);
    ofstream fout(argVariables[2],ios::binary);

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

    char b[4096];
    // while(fin.read((char*)b,sizeof(b)))  //typecasting the int 
    // {
    //  fout.write((char*)b,fin.gcount());   
    // }
    // fout.write(b, fin.gcount());
    //////////can also be written as
    while(!fin.eof()){
        fin.read(b,sizeof(b));
        fout.write(b,sizeof(b));
    }

    fin.close();
    fout.close();
    return 0;
}