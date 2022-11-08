#!/bin/bash

for((i=1; i<=100; i++))
do
    ./countAverageMaxCycleLen < ./max_cycle_len_8000_outputs/${i}_max_cycle_len_output.txt >> ./average/average_max_cycle_len_8000_2.txt
done
