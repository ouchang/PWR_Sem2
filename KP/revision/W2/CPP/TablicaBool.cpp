#include <iostream>
#include "TablicaBool.hpp"

using namespace std;

TablicaBool::TablicaBool(int l) {
    this->liczbaUczniow = l;
    tab = new bool[liczbaUczniow];
}

void TablicaBool::Obecny(int idx) {
    this->tab[idx] = true;
}

void TablicaBool::Nieobecny(int idx) {
    this->tab[idx] = false;
}

bool TablicaBool::CzyObecny(int idx) throw(string){
    if(idx > liczbaUczniow || idx < 1) throw (string)"Podano bledny indeks ucznia";
    if(tab[idx]) {
        return true;
    }
    return false;
}

TablicaBool::~TablicaBool() {
    delete tab;
}
