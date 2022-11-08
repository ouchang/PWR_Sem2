#include <iostream>
#include <string>
#include "TrojkatPascala.hpp"
using namespace std;

int main(int argc, char* argv[]) {
    WierszTrojkataPascala *W;
    int n,x,a;

    //Tworzenie n-tego wiersza trójkąta Pascala
    try {
        n = stoi(argv[1]);
        W = new WierszTrojkataPascala(n);
    } catch (invalid_argument const& e) {
        cout << argv[1] << " - nieprawidłowa dana" << endl;
        return 1;
    } catch (string e) {
        cout << argv[1] << " - " << e;
        return 1;
    }

    //Analiza zapytań o x-ową liczbę w wierszu
    for(int i=2; i<argc; i++) {
        try { 
            x = stoi(argv[i]);

            a = W->wspolczynnik(x);
            cout << argv[i] << " - " << a << endl;

        } catch (invalid_argument const& e) {
            cout << argv[i] << " - nieprawidłowa dana" << endl;
        }  catch (string e) {
            cout << argv[i] << " - " << e << endl;
        } 
    }

    delete W;
    return 0;
}
