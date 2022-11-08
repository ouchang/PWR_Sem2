#!/bin/bash

set -e

numtests=$1
mkdir -p gnuPlot_MaxCycle
data_file="gnuPlot_MaxCycle/test2_max_${numtests}"
csv_file="gnuPlot_MaxCycle/test2_max_${numtests}.csv"

> ${data_file}

echo ${numtests} | ./maxCycle >> ${data_file}

echo "lengthperm,avg,harm" > ${csv_file}
cat ${data_file} | tr ' ' ',' >> ${csv_file}

gnuplot <<-EOFMarker
  set terminal png size 800,600
  set output "$data_file.png"
  set title "Average length of the longest cycle"
  set xlabel "Permutation's length"
  set ylabel "Average length of the longest cycle"
  plot "$data_file" using 1:2 with lines title 'avg', "$data_file" using 1:3 with lines title 'Golomb-Dickman'
EOFMarker
