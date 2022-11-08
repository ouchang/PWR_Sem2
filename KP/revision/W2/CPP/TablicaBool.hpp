#pragma once

#include <iostream>

using namespace std;

class TablicaBool {
    public:
        bool *tab;
        int liczbaUczniow;

        TablicaBool(int l);
        void Obecny(int idx);
        void Nieobecny(int idx);
        bool CzyObecny(int idx) throw(string);
        ~TablicaBool();
};
