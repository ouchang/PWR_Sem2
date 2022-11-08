#include <iostream>
#include <stdio.h>
using namespace std;

double CountPerm[101]; //Array to count permutations with k cycles

int main() {
    int n; //Length of the permutation
    double average=0; //Average number of cycles
    int num_of_cycles; //Number of cycles in a given permutation
    double numOfTests; //Number of generated permutation in a given experiment
    double probability; //Probability of having number of cycles equals to i

    scanf("%lf", &numOfTests);
    scanf("%d", &n);

    //Counting how many permutations have number of cycles equals to i
    for(int i=1; i<=numOfTests; i++) {
        scanf("%d", &num_of_cycles);
        CountPerm[num_of_cycles]++;
    }

    //Counting the average number of cycles
    for(int i=1; i<=n; i++) {
        probability = CountPerm[i] / numOfTests;
        average += i*probability;
    }

    printf("%lf\n", average);
}
