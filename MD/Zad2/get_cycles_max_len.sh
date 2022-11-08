#!/bin/bash

for((i=1; i<=100; i++))
do
	while read line
    do
	    echo ${i} ${line} | ./countMaxCycleLen
    done < ./Fisher-Yates/outputs/${i}_output.txt | tee ./max_cycle_len_outputs/${i}_max_cycle_len_output.txt
done
