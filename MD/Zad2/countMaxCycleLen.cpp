#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;

vector< vector <int> > Cycles; //Vector of vectors for saving the cycles of permutation

//ATTENTION: I assume that permutation has elements from 1 to n

int main() {
    int n; //Size of the permutation
    int startingIdx, cycleCounter=0; //Index from which given cycles starts, number of cycles

    //Entering parameters
    scanf("%d", &n);

    int Arr[n+1]; //Permutation
    bool Visited[n+1]; //Array for saving which element of permutation was checked

    //Initializing permutation array
    for(int i=1; i<=n; i++) {
        scanf("%d", &Arr[i]);
    }

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

            cycleCounter++;
        }
    }

    //Finding the length of the longest cycle
    int maxCycleLen=0;
    for(int i=0; i<cycleCounter; i++) {
        if(maxCycleLen < Cycles[i].size()) {
            maxCycleLen = Cycles[i].size();
        }
        Cycles[i].clear();
    }

   printf("%d\n", maxCycleLen);
}
