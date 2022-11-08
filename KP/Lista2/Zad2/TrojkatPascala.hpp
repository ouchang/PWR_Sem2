#pragma once

#include <iostream>
using namespace std;

class WierszTrojkataPascala {
    public: 
        //Atrybuty
        int *Wiersz; //Tablica zawierająca n-ty wiersz trojkąta Pascala
        int n; //Numer wiersza

        //Metody
        int wspolczynnik(int m) throw(string);
    
        //Konstruktor
        WierszTrojkataPascala(int n) throw(string);

        //Destruktor
        ~WierszTrojkataPascala();
};
