#!/bin/bash

echo "-----------------------------------------------------------"
if [ $# -eq 0 ]
then
	echo "Usage: $0 [file] [folder]"
fi


for file in "$@"
do 
	if [ ! -e "$file" ]
	then
		echo "$file: no such file or directory"
	elif [ -f "$file" ]
	then
		echo "$file: regular file"
	elif [ -d "$file" ]
	then
		echo "$file: Directory"
	else
		echo "$file: unknown file type"
	fi
done

echo "--------------------------------------------------------------"
