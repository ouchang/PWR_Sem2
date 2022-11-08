#include <iostream>
#include <string>
#include "Pierwsze.hpp"
using namespace std;

int main(int argc, char* argv[]) {
    int n,x,p; 
    LiczbyPierwsze *T;

    try {
        //Tworzenie tablicy
        n = stoi(argv[1]); //Wczytuje zakres (n)
    
        T = new LiczbyPierwsze(n);
    } catch(invalid_argument const& ex) {
        cout << argv[1] << " - nieprawidłowa dana" << endl;
        return 0;
    }

    //Analiza zapytań o i-tą liczbę pierwszą
    for(int i=2; i<argc; i++) {
        try {  
            x = stoi(argv[i]); //Wczytywanie zapytania
            
            //Sprawdzenie czy zapytanie mieści się w zakresie
            //odnalezionych liczb pierwszych
            if((x >= 0) && (x <= T->k)) {
                p = T->liczba(x);
                cout << x << " - " << p << endl;
            } else {
                cout << x << " - liczba spoza zakresu" << endl;
            }
        } catch(invalid_argument const& ex) {
            cout << argv[i] << " - nieprawidłowa dana" << endl;
        }
    }

    delete T;
    return 0;
}
