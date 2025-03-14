# include <iostream>
# include <fstream>

using namespace std;
typedef unsigned char byte;

int main()
{
	cout<< "enter the mp3 filename (including the .mp3): "<< endl;
	char buff[100];
	cin.getline(buff,100);
	byte *array;
	ifstream in(buff, ios::in|ios::binary);

	if(!in)
	{
		cout <<"no file found" << endl;
		exit(1);
	}
    int count = 0;
	while(in)
	{
		char ch;
		in.get(ch);
		array[count] = ch;
        count++;
	}

	
    in.close();
	for(int i=0;i<count;i++)
		cout << array[i];
	cout <<endl;
   
	return 0;
}

//Reference: https://www.physicsforums.com/threads/is-this-c-code-correct-for-reading-bytes-from-an-mp3-file.65018/
