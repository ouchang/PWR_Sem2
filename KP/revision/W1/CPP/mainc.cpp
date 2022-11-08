#include <iostream>
using namespace std;

class Pojazd {
    public:
        string nazwa;
        string nr_rejestracji;
};

class Samochod {
    public:
        double spalanie;

        double ObliczSpalanie(int km) {
            return this->spalanie * km;
        }
};

class SamochodOsobowy : public Samochod {
    public:
        int liczba_miejsc;

        double ObliczSpalanie(int km) {
            return this->liczba_miejsc * 50 + km * this->spalanie;
        }
};

class Amfibia : public Pojazd, public Samochod {
    public:
        void PokazInfo() {
            cout << "NAZWA: " << this->nazwa << " NR REJESTRACJI: " << this->nr_rejestracji << " SPALANIE: " << this->spalanie << endl;
        }
};

int main(int args, char* Arg[]) {
    Pojazd *p = new Pojazd();
    SamochodOsobowy *s = new SamochodOsobowy();
    Amfibia *a = new Amfibia();

    p->nazwa = "Suzuki Swift 34";
    p->nr_rejestracji = "POU8987";

    s->liczba_miejsc = 5;
    s->spalanie = 5.4;

    a->nazwa = "Toyota Auris 19";
    a->nr_rejestracji = "UI4456";
    a->spalanie = 6.7;

    cout << "SPALANIE: " << s->ObliczSpalanie(50) << endl;
    cout << "SPALANIE: " << a->ObliczSpalanie(50) << endl;
    a->PokazInfo();
}
