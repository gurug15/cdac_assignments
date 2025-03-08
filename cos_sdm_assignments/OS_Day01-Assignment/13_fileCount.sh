#!/bin/bash



#read -p "enter absolute path of directory: " NAME
COUNT=$(ls -l $PWD | wc -l | awk '{print $1}')
#echo $COUNT
echo -n "Files and Directorise are: " 
echo $(( $COUNT-1 ))
