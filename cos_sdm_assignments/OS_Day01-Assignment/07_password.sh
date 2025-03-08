#!/bin/bash


read -p "enter no of words for password:" NUM

password=$(< /dev/urandom tr -dc 'A-Za-z0-9' | head -c $NUM)
echo "your generated password is: $password"

