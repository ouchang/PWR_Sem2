#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
    double harmonicNum=0.0;

    //Counting harmonic numbers by summing fractions
    for(double i=1; i<=100; i+=1.0) {
        harmonicNum = 0.0;
        for(double j=1; j<=i; j+=1.0) {
            harmonicNum += 1/j;
        }
        printf("%lf\n", harmonicNum);
    }
}
