#!/bin/bash


read -p "Enter File name: " NAME
COUNT=$(wc -w < $NAME | awk '{print $1}')


echo $COUNT
