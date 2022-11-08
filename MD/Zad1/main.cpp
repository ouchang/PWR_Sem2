#include <vector>
#include <stdio.h>
#include <iostream>
using namespace std;

//Funkcja zwracająca następny element dla krotki L w porządku leksykograficznym
void next_tuple(vector<int> &L, int n, int k) {
    int border=n+1; //"Ograniczenie górne" dla cyfr z krotki L
    bool is_last = false; //Czy została zwiększona ostatnia cyfra z krotki?
    bool found_tuple = false; //Czy został znaleziony następny element dla krotki L?

    //Analizuję krotkę od tyłu
    int i=k-1;
    for(; i>=0; i--) {
        //Sprawdzam czy mogę zwiększyć aktualną cyfrę o jeden
        //tak, aby zachować warunek L[i] < border
        if(border - L[i] > 1) {
            //Zwiększam cyfrę z krotki
            L[i] += 1;

            //Sprawdzam czy zwiększona cyfra jest ostatnia w krotce
            if(i == k-1) 
                is_last = true;

            //Zaznaczam, że znaleziono następny element w porządku leks.
            found_tuple = true;
            break;
        } else {
            //Przed przejściem do cyfry o mniejszym indeksie, w krotce
            //podmieniam ograniczenie górne (border) na aktualnie przeanalizowaną i-tą cyfrę,
            //bo wiemy, że cyfra o indeskie (i-1) musi być mniejsza od i-tej cyfry.
            border = L[i];
        }
    }

    //Jeżeli została zwiększona inna cyfra niż ostatnia z krotki,
    //wówczas należy ustawić cyfry od indeksu i do k-1 w jak najmniejszym
    //porządku leksykograficznym, nie zmieniając prz tym wartości na
    //i-tym indeksie
    if(found_tuple && !is_last) {
        for(int j=i+1; j<k; j++) {
            L[j] = L[j-1] + 1;
        }

        return;
    }

    //Nie udało się znaleźć następnego
    //w porządku leksykograficznym elementu

    //Zwracam krotkę z pierwszym elementem ustawionym na zero
    //jako sygnał, że L to ostatni element porządku.
    //(W innym przypadku zero nigdy nie pojawi się jako element krotki)
    if(!found_tuple) {
        L[0] = 0;
    }
}

//Generator porządku leksykograficznego na zbiorze M(n,k)
void gen_tuples(int n, int k) {
    vector <int> L; //Element porządku leks. na zbiorze M(n,k), tzw. krotka

    //Sprawdzam poprawność wprowadzonych danych
    if((n < 0) || (k < 0) || (k > n)) {
        printf("Błędne dane!\n");
        return;
    }

    //Ustawiam krotke L na najmniejszy element
    //w porządku leksykograficznym: (1,2,...,k)

    for(int i=1; i<=k; i++) {
        L.push_back(i);
    }

    while(L[0] != 0) { //Pętla działa dopóki nie otrzyma sygnału, że już koniec porządku
        //Wyświetlanie
        printf("(");
        for(int i=0; i<k; i++) {
            if(i != k-1)
                printf("%d, ", L[i]);
            else 
                printf("%d)\n", L[i]); 
        }

        //Wyznaczanie następnego w porządku
        //leksykograficznym elementu
        next_tuple(L, n, k);
    }
}

int main() {
    int n; //Analizujemy zbiór {1,...,n}
    int k; //Analizujemy k-elementowe krotki

    printf("Podaj kolejno liczby n oraz k:\n");
    scanf("%d %d", &n, &k);

    gen_tuples(n, k);
}
