#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;

vector< vector <int> > Cycles; //Vector of vectors for saving the cycles of permutation

//ATTENTION: I assume that permutation has elements from 1 to n

int main() {
    int n; //Size of the permutation
    int startingIdx; //Index from which given cycles starts

    //Entering parameters
    scanf("%d", &n);

    int Arr[n+1]; //Permutation
    bool Visited[n+1]; //Array for saving which element of permutation was checked

    //Initializing permutation array
    for(int i=1; i<=n; i++) {
        scanf("%d", &Arr[i]);
        Visited[i] = false;
    }

    //Converting permutation into cycles
    int j; //Index of the element from a given cycle
    for(int i=1; i<=n; i++) {
        if(!Visited[i]) {
            vector<int> currCycle; //

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

   //Number of cycles in permutation
   printf("%ld\n", Cycles.size());

    //Printing the cycles
   for(int i=0; i<Cycles.size(); i++) {
        printf("(");
        for(int j=0; j<Cycles[i].size(); j++) {
            if(j != Cycles[i].size()-1)
                printf("%d ", Cycles[i][j]);
            else
                printf("%d", Cycles[i][j]);
        }
        printf(")\n");
   }
}
