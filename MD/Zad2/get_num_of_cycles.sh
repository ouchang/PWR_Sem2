#!/bin/bash

for((i=1; i<=100; i++))
do
    while read line
    do
	    echo ${i} ${line} | ./convertToCycles
    done < ./Fisher-Yates/outputs/${i}_output.txt | tee ./no_of_cycles_5000_outputs/${i}_num_cycle_output.txt
done
