#include <iostream>
#include <stdio.h>
#include <cstring>
#include <vector>
#include <chrono>
#include <random>
using namespace std;

int Arr[101]; //Array containing shuffled permutation
bool Visited[101]; //Array for saving which element of permutation was checked
double CountPerm[101]; //Array to count permutations with k cycles
vector< vector <int> > Cycles; //Vector of vectors for saving the cycles of permutation

double const Golomb_Dickman = 0.6243299885;

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

void convertIntoCycles(int n) {
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
}

int findMaxLenOfCycle() {
    //Finding the length of the longest cycle
    int maxCycleLen=0;
    for(int i=0; i<Cycles.size(); i++) {
        if(maxCycleLen < Cycles[i].size()) {
            maxCycleLen = Cycles[i].size();
        }
        Cycles[i].clear();
    }

    return maxCycleLen;
}

double countAverageMaxCycleLen(int n, double numOfTests) {
    double average; //Average length of the longest cycle
    double probability; //Probability of having the longest cycle's length equals to i

    //Counting the average length of the longest cycle
    for(int i=1; i<=n; i++) {
        probability = i * CountPerm[i]/numOfTests;
        average += probability;
    }

    return average;
}

double getGolombDickmanFunc(int n) {
    return (double)(n*Golomb_Dickman);
}

int main() {
    int numberOfTests; //Number of tests
    int currMaxCycleLen; //Maximal length of the longest cycle in a given permutation
    double average; //Average length of the longest cycle 
    double Golomb_Dickman_func; //Average length of the longest cycle according to Golomb-Dickman

    scanf("%d", &numberOfTests);

    for(int n=1; n<=100; n++) { //Length of the permutation
        memset(Arr, 0, sizeof(Arr));
        memset(CountPerm, 0, sizeof(CountPerm));
        for(int i=1; i<=numberOfTests; i++) {
            generatePermutation(n);
            convertIntoCycles(n);

            currMaxCycleLen = findMaxLenOfCycle();

            //Cleaning vector of cycles
            Cycles.clear();
            
            CountPerm[currMaxCycleLen]++;
        }
        
        average = countAverageMaxCycleLen(n, numberOfTests);
        Golomb_Dickman_func = getGolombDickmanFunc(n);

        printf("%d %lf %lf\n", n, average, Golomb_Dickman_func);
    }
}
