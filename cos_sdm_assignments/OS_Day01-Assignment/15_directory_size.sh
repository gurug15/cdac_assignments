#!/bin/bash

if [ -z "$1" ]
then
  echo "Usage: $0 <directory>"
  exit 1
fi

du -sh $1 | awk '{print $1}'


