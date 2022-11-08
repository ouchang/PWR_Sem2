#!/bin/bash

length=$1
counter=$2

> ${length}_output.txt

for ((i=1; i<=${counter}; i++)); do
  echo ${length} | ./main
done | tee ./outputs_5000/${length}_output.txt
