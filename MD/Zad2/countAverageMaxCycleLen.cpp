#include <iostream>
#include <stdio.h>
using namespace std;

double CountPerm[101]; //Array to save how many permutations have maximal cycle with length equals to k

int main() {
    double average; //Average length of the longest cycle
    double probability; //Probability of having the longest cycle's length equals to i
    int max_cycle_len; //The longest cycle's length in a given permutation
    int n; //Length of the permutation
    double numOfTests; //Number of generated permutations in a given experiment

    scanf("%lf", &numOfTests);
    scanf("%d", &n);

    //Counting how many permutations have the longest cycle of length equal to i
    for(int i=1; i<=numOfTests; i++) {
        scanf("%d", &max_cycle_len);
        CountPerm[max_cycle_len]++;
    }

    //Counting the average length of the longest cycle
    for(int i=1; i<=n; i++) {
        probability = i * CountPerm[i]/numOfTests;
        average += probability;
    }

    printf("%lf\n", average);
}
