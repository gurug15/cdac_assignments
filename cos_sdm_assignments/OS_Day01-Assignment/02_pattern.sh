#!/bin/bash




for(( i=0;i<=$1;i++ ))
do
	for(( j=0;j<i;j++ ))
	do
		echo -n "*"
	done

	echo
done

