#!/bin/bash





#read -p "Enter a Number series you want" n

ARR=$(cat ./names.txt)



for ele in "${ARR[@]}"
do
     if [[ ele == one ]]
     then
          echo "this is $ele"
          break
	fi	  
done       
