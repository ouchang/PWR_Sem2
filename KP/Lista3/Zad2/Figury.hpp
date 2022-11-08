#pragma once

#include <iostream>
using namespace std;

class Figura {
    public:

        //Metody
        virtual double Pole()=0;
        virtual double Obwod()=0;
};

class Czworokat : public Figura {
    public: 
        int bok1;
        int bok2;
        int bok3;
        int bok4;
        int kat;
};

class Kolo : public Figura {
    public: 
        //Atrybuty
        int promien;
    
        //Konstruktor
        Kolo(int promien) throw(string);

        //Metody
        double Obwod();
        double Pole();
};

class Pieciokat : public Figura {
    public: 
        //Atrybuty
        int bok;
    
        //Konstruktor
        Pieciokat(int bok) throw(string);

        //Metody
        double Obwod();
        double Pole();
};

class Szesciokat : public Figura {
    public: 
        //Atrybuty
        int bok;
    
        //Konstruktor
        Szesciokat(int bok) throw(string);

        //Metody
        double Obwod();
        double Pole();
};

class Kwadrat : public Czworokat {
    public: 
        //Konstruktor
        Kwadrat(int bok1, int bok2, int bok3, int bok4, int kat) throw(string);

        //Metody
        double Obwod();
        double Pole();
};

class Prostokat : public Czworokat {
    public:
        //Konstruktor
        Prostokat(int bok1, int bok2, int bok3, int bok4, int kat) throw(string);

        //Metody
        double Obwod();
        double Pole();
};

class Romb : public Czworokat {
    public: 
        //Konstruktor
        Romb(int bok1, int bok2, int bok3, int bok4, int kat) throw(string);

        //Metody
        double Obwod();
        double Pole();
};
