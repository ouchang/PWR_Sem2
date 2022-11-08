#!/bin/bash

for ((i=1; i<=100; i++))
do
	./countAverageNumCycles < ./no_of_cycles_8000_outputs/${i}_num_cycle_output.txt >> ./average/average_num_of_cycles_8000_2.txt
done
