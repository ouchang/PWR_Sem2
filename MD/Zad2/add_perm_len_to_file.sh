#!/bin/bash

for((i=1; i<=100; i++))
do
    echo -e "$(echo 8000)\n$(cat ./max_cycle_len_8000_outputs/${i}_max_cycle_len_output.txt)" > ./max_cycle_len_8000_outputs/${i}_max_cycle_len_output.txt
done
