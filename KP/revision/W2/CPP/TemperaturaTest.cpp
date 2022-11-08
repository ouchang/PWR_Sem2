#include <iostream>
#include "Temperatura.hpp"

using namespace std;

int main(int args, char* Arg[]) {
    Temperatura *t1 = new Temperatura();
    Temperatura *t2 = new Temperatura(56.7);

    cout << "TEMPERATURA W CELSJUSZACH: " << t2->Celsjusz() << " W KELVINACH: " << t2->Kelvin() << " W FAHRENHAITACH: " << t2->Fahrenheit() << endl;

    t1->setK(273.15);
    cout << "TEMPERATURA W CELSJUSZACH: " << t1->Celsjusz() << " W KELVINACH: " << t1->Kelvin() << " W FAHRENHAITACH: " << t1->Fahrenheit() << endl;

    delete t1;
    delete t2;
}
