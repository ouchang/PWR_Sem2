#include <iostream>
#include "Pierwsze.hpp"
using namespace std;

//Metoda
int LiczbyPierwsze::liczba(int m) {
    return P[m];
}

//Konstruktor
LiczbyPierwsze::LiczbyPierwsze(int n) {
    bool TP[n+1]; //Tymczasowa tablica do wyznaczenia liczb pierwszych

    TP[0] = false;
    TP[1] = false;

    for(int i=2; i<=n; i++) {
        TP[i] = true;
    }

    //Wyszukiwanie liczb pierwszych (Sito Eratostenesa)
    for(int i=2; i*i<=n; i++) {
        if(TP[i] == true) {
            for(int j=i*i; j<=n; j+=i) {
                TP[j] = false;
            }
        }
    }

    //Tworzenie tablicy z liczbami pierwszymi z zakresu od 2 do n
    int idx=0; //Indeks po tablicy P
    P = new int[n];

    for(int i=2; i<=n; i++) {
        if(TP[i] == true) {
            P[idx] = i;
            idx++;
        }
    }

    k = idx-1;
}

//Destruktor
LiczbyPierwsze::~LiczbyPierwsze() {
    delete P;
}
