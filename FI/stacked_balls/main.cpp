#include <stdio.h>
#include <iostream>
#include <cmath>
using namespace std;

//Funkcja wyznacza wysokosc aktualnie analizowanej pilki
double countHeight(double v0, double g) {
    double tw=0.0; //Czas wznoszenia
    double h=0.0; //Wysokosc, na jaka pilka sie wzniesie

    //Wyznaczam czas wznoszenia ze wzoru: 0 = V0 - gt
    tw = v0 / g;
    
    //Wyznaczam wysokosc
    h = v0 * tw - 0.5 * g * tw * tw;

    return h;
}

//Funkcja sprawdza czy dana liczba pilek po odbiciu osiagnie wysokosc Mount Everest
void fallingBalls(int liczba_pilek, double h_start) {
    //h_start -> Wysokosc, z ktorej zrzucamy pilki
    double g=9.81; //Przyspieszenie ziemskie
    double ts=0.0; //Czas spadku
    long double u=0.0, v=0.0; //Predkosci odpowiednio pilki nizej ustawionej i pilki ustawionej wyzej
    long double h_pilki=0.0; //Wysokosc uzyskana przez aktualnie analizowana pilke

    const int H_EVEREST = 8850;

    if(h_start <= 0.0) {
        printf("Pilki sa juz na ziemi!\n");
        return;
    }

    //Wyznaczam czas spadku pilki z wysokosci h_start ze wzoru:
    // 0 = h_start - 0.5*g*t*t (v0 = 0)

    ts = sqrt(2 * h_start / g);

    //Wyznaczam predkosc pierwszej pilki (na spodzie ustawienia)
    //ze wzoru: v = gt

    u = g*ts;

    for(int i=2; i<=liczba_pilek; i++) {
        //Zgodnie z opracowaniem i zalozeniami, predkosc po zderzeniu pilki ustawionej wyzej
        // jest 3 razy wieksza od predkosci przed zderzeniem pilki ustawionej nizej 

        v = 3*u;

        //Wyznaczam wysokosc uzyskana przez pilke
        h_pilki = countHeight(v, g);

        //Sprawdzam czy pilka dotrze na Mount Everest
        if(h_pilki >= H_EVEREST) {
            printf("Wystarczy %d pilek, by najmniejsza z nich wzleciala na wyskosc Mount Everest\n", i);
            printf("Najmniejsza pilka osiaga prędkosc: %Lf i wysokosc: %Lf\n", v, h_pilki);
            return ;
        }

        //Przechodzimy do zderzenia z pilka ustawiona jeszcze wyzej 
        u = v; //Obecnie "wyzej polozona pilka" staje sie "nizej polozona pilka"
    }

    printf("Podana liczba pilek jest niewystarczajaca!\n");
    printf("Najmniejsza pilka osiaga predkosc: %Lf i wysokosc: %Lf\n", v, h_pilki);
}

int main() {
    double h_start;
    int liczba_pilek;

    printf("Podaj liczbe pilek: ");
    scanf("%d", &liczba_pilek);
    printf("Podaj wysokosc poczatkowa: ");
    scanf("%lf", &h_start);

    fallingBalls(liczba_pilek, h_start);
}
