#include <iostream>
#include <cmath>
#include "Figury.hpp"
using namespace std;

//KOLO
Kolo::Kolo(int promien) throw(string) {
    if(promien <= 0) throw (string)"Nieprawidłowa dana";
    this->promien = promien;
}

double Kolo::Obwod() {
    double pi = 3.14;
    return 2*pi*promien;
}

double Kolo::Pole() {
    double pi = 3.14;
    return pi*promien*promien;
}

//PIECIOKAT
Pieciokat::Pieciokat(int bok) throw(string) {
    if(bok <= 0) throw (string)"Nieprawidłowa dana";
    this->bok = bok; 
}

double Pieciokat::Obwod() {
    return 5*bok;
}

double Pieciokat::Pole() {
    double pierwiastek5 = sqrt(5);
    return 0.25 * sqrt(25 + 10*pierwiastek5) * bok;
}

//SZESCIOKAT
Szesciokat::Szesciokat(int bok) throw(string) {
    if(bok <= 0) throw (string)"Nieprawidłowa dana";
    this->bok = bok; 
}

double Szesciokat::Obwod() {
    return 6*bok;
}

double Szesciokat::Pole() {
    double pierwiastek3 = sqrt(3);
    return 3 * 0.5 * bok * bok * pierwiastek3;
}

//KWADRAT
Kwadrat::Kwadrat(int bok1, int bok2, int bok3, int bok4, int kat) throw(string) {
    if(bok1 <= 0 || bok2 <= 0 || bok3 <= 0 || bok4 <= 0 || kat <= 0 || kat > 90) throw (string)"Nieprawidłowa dana";
    this->bok1 = bok1;
    this->bok2 = bok2;
    this->bok3 = bok3;
    this->bok4 = bok4;
    this->kat = kat;
}

double Kwadrat::Obwod() {
    return 4*bok1;
}

double Kwadrat::Pole() {
    return bok1*bok1;
}

//PROSTOKAT
Prostokat::Prostokat(int bok1, int bok2, int bok3, int bok4, int kat) throw(string) {
    if(bok1 <= 0 || bok2 <= 0 || bok3 <= 0 || bok4 <= 0 || kat <= 0 || kat > 90) throw (string)"Nieprawidłowa dana";
    this->bok1 = bok1;
    this->bok2 = bok2;
    this->bok3 = bok3;
    this->bok4 = bok4;
    this->kat = kat;
}

double Prostokat::Obwod() {
    return bok1 + bok2 + bok3 + bok4;
}

double Prostokat::Pole() {
    if(bok1 != bok2) {
        return bok1 * bok2;
    } else { 
        return bok1 * bok3;
    }
}

//ROMB
Romb::Romb(int bok1, int bok2, int bok3, int bok4, int kat) throw(string) {
    if(bok1 <= 0 || bok2 <= 0 || bok3 <= 0 || bok4 <= 0 || kat <= 0 || kat > 90) throw (string)"Nieprawidłowa dana";
    this->bok1 = bok1;
    this->bok2 = bok2;
    this->bok3 = bok3;
    this->bok4 = bok4;
    this->kat = kat;
}

double Romb::Obwod() {
    return 4*bok1;
}

double Romb::Pole() {
    //Kowersja stopni na radiany
    double tkat = kat * (3.14)/180;

    return bok1 * bok2 * sin(tkat);
}
