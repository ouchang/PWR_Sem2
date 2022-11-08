#include <iostream>
#include <stdio.h>
#include <vector>
#include <chrono>
#include <cstring>
#include <random>
using namespace std;

int Arr[101]; //Array containing shuffled permutation
bool Visited[101]; //Array for saving which element of permutation was checked
double CountPerm[101]; //Array to count permutations with k cycles
vector< vector <int> > Cycles; //Vector of vectors for saving the cycles of permutation

void generatePermutation(int n) {
    mt19937 random(chrono::steady_clock::now().time_since_epoch().count());
    int randomVal, temp; //random value, temporary value 

    //Initializing the arrays (from 1 to n)
    for(int i=1; i<=n; i++) {
        Arr[i] = i;
    }

    for(int i=n; i>1; i--) {
        randomVal = (random() % i) + 1; //Getting random value between 1 and i
        //Swaping the elements from the permutation
        temp = Arr[i];
        Arr[i] = Arr[randomVal];
        Arr[randomVal] = temp;
    }
}

int countNumberOfCycles(int n) {
    int startingIdx; //Index from which given cycles starts

    //Initializing bool array 
    for(int i=1; i<=n; i++)
        Visited[i] = false;


    //Converting permutation into cycles
    int j; //Index of the element from a given cycle
    for(int i=1; i<=n; i++) {
        if(!Visited[i]) {
            vector<int> currCycle; 

            startingIdx = i;
            j = i;

            Visited[j] = true; //Setting element from cycle as checked
            currCycle.push_back(j); //Adding element to cycle's vector

            //Going through the rest of the cycle
            while(startingIdx != Arr[j]) {
                j = Arr[j];
                Visited[j] = true;
                currCycle.push_back(j);
            }

            //Adding cycle to the vector of cycles
            Cycles.push_back(currCycle);
        }
    }

    return (int)(Cycles.size());
}

double countAverageNumCycles(int n, double numOfTests) {
    double average=0; //Average number of cycles
    double probability; //Probability of having number of cycles equals to i

    //Counting the average number of cycles
    for(int i=1; i<=n; i++) {
        probability = CountPerm[i] / numOfTests;
        average += i*probability;
    }

    return average;
}

double generateHarmonicNumber(int n) {
    double harmonicNum=0.0; //Harmonic number

    //Counting harmonic number by summing fractions
    for(double i=1; i<=n; i+=1.0) {
        harmonicNum += 1/i;
    }

    return harmonicNum;
}

int main() {
    double numberOfTests; 
    int currNumberOfCycles; //Number of cycles for a given permutaion
    double average; //Average number of cycles
    double harmonicNum; //Harmonic number

    scanf("%lf", &numberOfTests);

    for(int n=1; n<=100; n++) { //Length of the permutation
        memset(Arr, 0, sizeof(Arr));
        memset(CountPerm, 0, sizeof(CountPerm));
        for(int i=1; i<=numberOfTests; i++) {
            generatePermutation(n);

            currNumberOfCycles = countNumberOfCycles(n);
            
            //Cleaning vector of cycles
            Cycles.clear();

            //Counting how many permutations have number of cycles equals to i
            CountPerm[currNumberOfCycles]++;
        }
        
        average = countAverageNumCycles(n, numberOfTests);
        harmonicNum = generateHarmonicNumber(n);

        printf("%d %lf %lf\n", n, average, harmonicNum);
    }
}
