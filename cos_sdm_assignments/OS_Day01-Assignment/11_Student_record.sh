#!/bin/bash


read -p "Enter Roll NO: " NUM
read -p "enter your name " NAME
read -p "Enter Hindi marks: " HNUM
read -p "Enter Maths marks: " MNUM
read -p "Enter Physics marks: " PNUM



num=$(cat student_record.txt | grep -oi $NUM)

touch log.txt

if [[ $num ]]
then
	echo "roll number exists" >> log.txt
	exit 1
fi

for marks in $HNUM $MNUM $PNUM
do 
	if [ $marks -gt 99 ] || [ $marks -lt 1 ]
	then
		echo "marks out of range" >>log.txt
		exit 1
	fi
done



totalPer(){
       

	PER=$(( ($1+$2+$3)/3 ))
	echo "percentage is: $PER"

}


totalPer $HNUM $PNUM $MNUM
echo "$NUM $NAME $HNUM $MNUM $PNUM" >> student_record.txt
