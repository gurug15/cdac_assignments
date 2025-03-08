#!/bin/bash

read -p "enter a number: " NUM


ANS=$NUM%2

if [[ $ANS -eq 0 ]]
then
	echo "The $NUM is even"
else
	echo "the $NUM is odd"
fi
