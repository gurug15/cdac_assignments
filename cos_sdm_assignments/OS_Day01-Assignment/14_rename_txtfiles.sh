#!/bin/bash


FILES=$(find $PWD/textfiles/ -type f)

echo $FILES 
Folder='renamed'
mkdir -p $Folder
for file in $FILES
do
	NAME=$(date -u +%H-%M-%S-%N_%d-%m-%y)
	mv $file "$PWD/$FOLDER/$NAME.txt"

done
