#!/bin/bash


read -p "Enter a first String: " F
read -p "Enter a Second String: " S


concat(){
  
 echo "$1 $2"

}





compare(){
  
    if [[ "$1" == "$2" ]]
    then
            echo "strings are equal"
    else 
	    echo "strings are not equal"
    fi

}

reverse(){
	echo "$1" | rev
}


check_palindrome(){
	reversed=$(echo "$1" | rev)
	if [[ "$1" == "$reversed" ]]
	then
		echo "$1 is a palandrome"
	else
		echo "$1 is not a palandrome"
	fi
}


echo "concatinated: $(concat $F $S)"
echo "reversed: $(reverse $F)"
echo "Palandrome: $(check_palindrome $F)"
echo "Compare: $(compare $F $S)"


