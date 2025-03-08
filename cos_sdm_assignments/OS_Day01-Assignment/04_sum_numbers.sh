#!/bin/bash


read -p "enter all the numbers with spaces: " NUM

ARR=($NUM)
SUM=0
echo "${ARR[@]}"
for ELE in "${ARR[@]}"
do
       SUM=$(($SUM + $ELE))
done

echo "$#"
echo "$SUM"
