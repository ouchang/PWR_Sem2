#!/bin/bash

set -e

numtests=$1
mkdir -p ./gnuPlot
data_file="./gnuPlot/test2_${numtests}"
csv_file="./gnuPlot/test2_${numtests}.csv"

> ${data_file}

echo ${numtests} | ./numCycles >> ${data_file}

echo "lengthperm,avg,harm" > ${csv_file}
cat ${data_file} | tr ' ' ',' >> ${csv_file}

gnuplot <<-EOFMarker
  set terminal png size 800,600
  set output "$data_file.png"
  set title "Average number of cycles"
  set xlabel "Permutation's length"
  set ylabel "Average number of cycles"
  plot "$data_file" using 1:2 with lines title 'avg', "$data_file" using 1:3 with lines title 'harm'
EOFMarker
