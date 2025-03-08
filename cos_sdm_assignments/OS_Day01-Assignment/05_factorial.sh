#!/bin/bash



fact=1
Fact() {
    
	
        if [[ $1 -le 1 ]]
	then
		echo 1
	else 
	fact=$(( $1 * $(Fact $(( $1-1 ))) )) 
	echo $fact
        fi
}




read -p "enter a number: " NUM
Fact $NUM
