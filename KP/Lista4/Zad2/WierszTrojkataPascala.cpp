#include <iostream>
#include "TrojkatPascala.hpp"
using namespace std;

//Metoda
int WierszTrojkataPascala::wspolczynnik(int m) throw(string) {
    if((m < 0) || (m > n)) throw (string)"liczba spoza zakresu";
    return Wiersz[m];
}

//Konstruktor
WierszTrojkataPascala::WierszTrojkataPascala(int n) throw(string) {
    if(n < 0) throw (string)"nieprawidłowa dana";

    //UWAGA: Liczba wartości w i-tym wierszu jest równa i+1

    int TrojkatPascala[n+1][n+1];
    this->n = n;

    //Tworzę Trójkąt Pascala do (n-1)-ego wiersza włącznie
    TrojkatPascala[0][0] = 1;
    TrojkatPascala[1][0] = 1;
    TrojkatPascala[1][1] = 1;
    for(int i=2; i<n; i++) {
        TrojkatPascala[i][0] = 1;
        for(int j=1; j<i; j++) {
            TrojkatPascala[i][j] = TrojkatPascala[i-1][j-1] + TrojkatPascala[i-1][j];
        }
        TrojkatPascala[i][i] = 1;
    }

    //Zapisuje n-ty wiersz w tablicy Wiersz
    Wiersz = new int[n+1];
    Wiersz[0] = 1;
    for(int j=1; j<n; j++) {
        Wiersz[j] = TrojkatPascala[n-1][j-1] + TrojkatPascala[n-1][j];
    }
    Wiersz[n] = 1;
}

//Destruktor
WierszTrojkataPascala::~WierszTrojkataPascala() {
    delete Wiersz;
}

