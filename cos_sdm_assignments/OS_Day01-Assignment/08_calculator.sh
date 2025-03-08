#!/bin/bash

Add() {

	sum=$(( $1+$2 ))
	echo $sum
}
Sub() {

	sum=$(( $1-$2 ))
	echo $sum
}
Mul() {

	sum=$(( $1*$2 ))
	echo $sum
}
Div() {

	sum=$(( $1/$2 ))
	echo $sum
}




echo "your choices:"
echo "A for Addition"
echo "S for Subtraction"
echo "D for Division"
echo "M for Multiplication"
read -p "Enter your Choice: " CHOICE
#read -p "enter first number: " NUM1
#read -p "enter second  number: " NUM2
case $CHOICE in
	A)      
	        
read -p "enter first number: " NUM1
read -p "enter second  number: " NUM2
		Add $NUM1 $NUM2;;
	S)
read -p "enter first number: " NUM1
read -p "enter second  number: " NUM2
	       	Sub $NUM1 $NUM2;;
	M)
read -p "enter first number: " NUM1
read -p "enter second  number: " NUM2
	       	Mul $NUM1 $NUM2;;
	D)
read -p "enter first number: " NUM1
read -p "enter second  number: " NUM2
	       	Div $NUM1 $NUM2;;
	*) echo "Invalid choice or arguments";;
esac
