#!/bin/bash


filename="$1"
while read line
do
    name=$line
    user=$(echo $line | cut -d: -f1)
    echo "Ciao: $user"
done < "$filename"