#include <iostream>
#include "TablicaBool.hpp"

using namespace std;

int main(int args, char* Arg[]) {
    TablicaBool *dziennik = new TablicaBool(25);
    bool uczen;

    dziennik->Obecny(9);
    dziennik->Nieobecny(13);

    try {
        uczen = dziennik->CzyObecny(9);
        if(uczen)
            cout << "UCZEN 9 JEST OBECNY" << endl;

        uczen = dziennik->CzyObecny(13);
        if(uczen)
            cout << "UCZEN 13 JEST OBECNY" << endl;
    } catch(string e) {
        cout << e << endl;
    }

    try {
        uczen = dziennik->CzyObecny(34);
    } catch(string e) {
        cout << e << endl;
    }

    delete dziennik;
}
