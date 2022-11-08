#include <iostream>
#include <stdio.h>
#include <random>
#include <chrono> 
using namespace std;

int main() {
    mt19937 random(chrono::steady_clock::now().time_since_epoch().count());

    int n; //Size of the array

    scanf("%d", &n);

    int Arr[n+1]; //Array containing shuffled permutation
    int randomVal, temp; //random value, temporary value 

    //Initializing the arrays (from 1 to n)
    for(int i=1; i<=n; i++) {
        Arr[i-1] = i;
    }
    
    for(int i=n-1; i>0; i--) {
        randomVal = random() % i; //Getting random value between 0 and n-1
        //Swaping the elements from the permutation
        temp = Arr[i];
        Arr[i] = Arr[randomVal];
        Arr[randomVal] = temp;
    }

    //Printing the shuffled permutation
    for(int i=0; i<n; i++) {
        printf("%d ", Arr[i]);
    }
    printf("\n");
}
