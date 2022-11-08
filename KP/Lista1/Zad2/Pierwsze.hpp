#pragma once

#include <iostream>
using namespace std;

class LiczbyPierwsze {
    
    public:
        //Atrybuty
        int *P; //Tablica z liczbami pierwszymi z zakresu od 2 do n
        int k; //Ilość liczb pierwszych w zakresie od 2 do n

        //Metoda
        int liczba(int m); 

        //Konstruktor
        LiczbyPierwsze(int n);

        //Destruktor
        ~LiczbyPierwsze();
};


