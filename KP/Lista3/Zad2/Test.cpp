#include <iostream>
#include <string>
#include "Figury.hpp"
using namespace std;

int main(int argc, char* argv[]) {
    //Dane o figurach
    int bok1, bok2, bok3, bok4, kat;
    int bok;
    int promien;

    //Wyniki metod
    double pole, obwod;

    //Konwertuje zapis rodzaju figur jako string
    string figury(argv[1]);

    int liczbaFigur = figury.size();

    Figura** F = new Figura*[liczbaFigur]; //Tablica z obiekatami odpowiednich figur

    //Wyznaczam poprawną liczbe parametrów figur
    int liczbaParametrow = 0;
    for(int i=0; i<liczbaFigur; i++) {
        if(figury[i] == 'c') {
            liczbaParametrow += 5;
        } else if(figury[i] == 'p' || figury[i] == 'o' || figury[i] == 's') {
            liczbaParametrow++;
        } else {
            cout << figury[i] << " - nieprawidłowy typ figury" << endl;
            return 0;
        }
    }

    int typ_idx=0;
    int ti=0;
    for(int i=2; i<liczbaParametrow+2; i++) { //bo paramtry są dopiero od 2 indeksu
        if(typ_idx < figury.length() && figury[typ_idx] == 'c') {
            //CZWOROKAT
            ti = i;

            //Zwiększam indeks i tak, by wskazywał na początek danych kolejnej figury
            i += 4; //bo jeszcze indeks i zostanie zwiększony o 1 po przejście tej iteracji

            //CZWOROKĄT
            try {
                bok1 = stoi(argv[ti]);
                //Zwiększam indeks i, by przesunać się do kolejnego parametru
                ti++;

                bok2 = stoi(argv[ti]);
                ti++;

                bok3 = stoi(argv[ti]);
                ti++;

                bok4 = stoi(argv[ti]);
                ti++;

                kat = stoi(argv[ti]);
            } catch(invalid_argument const& e) {
                cout << argv[ti] << " - nieprawidłowa dana" << endl;
                typ_idx++;
                continue;
            } catch (string e) {
                cout << e << endl;
                typ_idx++;
            } catch (exception const& e) {
                cout << "Nieprawidłość w parametrach" << endl;
                return 0;
            }

            //Sprawdzam jaki mamy czworokąt
            if((bok1 == bok2) && (bok1 == bok3) && (bok1 == bok4) && (kat == 90)) {
                //KWADRAT

                //Tworzę odpowiedni obiekt do danej figury
                try{ 
                    F[typ_idx] = new Kwadrat(bok1, bok2, bok3, bok4, kat);

                    //Uruchamiam metody
                    obwod = F[typ_idx]->Obwod();
                    pole = F[typ_idx]->Pole();

                    //Wyświetlanie
                    cout << "KWADRAT" << endl;
                    cout << "Obwód: " << obwod << endl;
                    cout << "Pole: " << pole << endl;

                    typ_idx++;
                } catch (string e) {
                    cout << e << endl;
                    typ_idx++;
                    continue;
                } catch (exception const& e) {
                    cout << "Nieprawidłowość w parametrach" << endl;
                    return 0;
                }
            } else if((bok1 == bok2) && (bok1 != bok3) && (bok3 == bok4)) {
                //PROSTOKĄT
                try{ 
                    F[typ_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);

                    //Uruchamiam metody
                    obwod = F[typ_idx]->Obwod();
                    pole = F[typ_idx]->Pole();

                    //Wyświetlanie
                    cout << "PROSTOKAT" << endl;
                    cout << "Obwód: " << obwod << endl;
                    cout << "Pole: " << pole << endl;

                    typ_idx++;
                } catch (string e) {
                    cout << e << endl;
                    typ_idx++;
                    continue;
                } catch (exception const& e) {
                    cout << "Nieprawidłowość w parametrach" << endl;
                    return 0;
                }
            } else if((bok1 == bok3) && (bok1 != bok2) && (bok2 == bok4)) {
                //PROSTOKĄT
                try{ 
                    F[typ_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);
                    
                    //Uruchamiam metody
                    obwod = F[typ_idx]->Obwod();
                    pole = F[typ_idx]->Pole();

                    //Wyświetlanie
                    cout << "PROSTOKAT" << endl;
                    cout << "Obwód: " << obwod << endl;
                    cout << "Pole: " << pole << endl;

                    typ_idx++;
                } catch (string e) {
                    cout << e << endl;
                    typ_idx++;
                    continue;
                }  catch (exception const& e) {
                    cout << "Nieprawidłowość w parametrach" << endl;
                    return 0;
                }
            } else if((bok1 == bok4) && (bok1 != bok2) && (bok2 == bok3)) {
                //PROSTOKĄT
                try{ 
                    F[typ_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);
                    
                    //Uruchamiam metody
                    obwod = F[typ_idx]->Obwod();
                    pole = F[typ_idx]->Pole();

                    //Wyświetlanie
                    cout << "PROSTOKAT" << endl;
                    cout << "Obwód: " << obwod << endl;
                    cout << "Pole: " << pole << endl;

                    typ_idx++;
                } catch (string e) {
                    cout << e << endl;
                    typ_idx++;
                    continue;
                } catch (exception const& e) {
                    cout << "Nieprawidłowość w parametrach" << endl;
                    return 0;
                }
            } else if((bok1 == bok2) && (bok1 == bok3) && (bok1 == bok4)) {
                //ROMB
                try{ 
                    F[typ_idx] = new Romb(bok1, bok2, bok3, bok4, kat);
                    
                    //Uruchamiam metody
                    obwod = F[typ_idx]->Obwod();
                    pole = F[typ_idx]->Pole();

                    //Wyświetlanie
                    cout << "ROMB" << endl;
                    cout << "Obwód: " << obwod << endl;
                    cout << "Pole: " << pole << endl;

                    typ_idx++;
                } catch (string e) {
                    cout << e << endl;
                    typ_idx++;
                    continue;
                } catch (exception const& e) {
                    cout << "Nieprawidłowość w parametrach" << endl;
                    return 0;
                }
            } else {
                cout << "Nie rozpoznano figury!" << endl;
                typ_idx++;
            }
        } else if((typ_idx < figury.length()) && (figury[typ_idx] == 'p')) { 
            //PIĘCIOKĄT
            try {
                bok = stoi(argv[i]);
                F[typ_idx] = new Pieciokat(bok);

                //Uruchamiam metody
                obwod = F[typ_idx]->Obwod();
                pole = F[typ_idx]->Pole();

                //Wyświetlanie
                cout << "PIECIOKAT" << endl;
                cout << "Obwód: " << obwod << endl;
                cout << "Pole: " << pole << endl;

                typ_idx++;
            } catch(invalid_argument const& e) {
                cout << argv[i] << " - nieprawidłowa dana" << endl;
                typ_idx++;
                continue;
            } catch (string e) {
                cout << e << endl;
                typ_idx++;
                continue;
            } catch (exception const& e) {
                cout << "Nieprawidłowość w parametrach" << endl;
                return 0;
            }
        } else if((typ_idx < figury.length()) && figury[typ_idx] == 's') {
            //SZESCIOKAT
            try {
                bok = stoi(argv[i]);
                F[typ_idx] = new Szesciokat(bok);

                //Uruchamiam metody
                obwod = F[typ_idx]->Obwod();
                pole = F[typ_idx]->Pole();

                //Wyświetlanie
                cout << "SZESCIOKAT" << endl;
                cout << "Obwód: " << obwod << endl;
                cout << "Pole: " << pole << endl;

                typ_idx++;
            } catch(invalid_argument const& e) {
                cout << argv[i] << " - nieprawidłowa dana" << endl;
                typ_idx++;
                continue;
            } catch (string e) {
                cout << e << endl;
                typ_idx++;
                continue;
            }  catch (exception const& e) {
                cout << "Nieprawidłowość w parametrach" << endl;
                return 0;
            }
        } else if((typ_idx < figury.length()) && figury[typ_idx] == 'o') { 
            //KOŁO
            try {
                promien = stoi(argv[i]);
                F[typ_idx] = new Kolo(promien);

                //Uruchamiam metody
                obwod = F[typ_idx]->Obwod();
                pole = F[typ_idx]->Pole();

                //Wyświetlanie
                cout << "KOLO" << endl;
                cout << "Obwód: " << obwod << endl;
                cout << "Pole: " << pole << endl;

                typ_idx++;
            } catch(invalid_argument const& e) {
                cout << argv[i] << " - nieprawidłowa dana" << endl;
                typ_idx++;
                continue;
            } catch (string e) {
                cout << e << endl;
                typ_idx++;
                continue;
            }  catch (exception const& e) {
                cout << "Nieprawidłowość w parametrach" << endl;
                return 0;
            }
        } 
    } 
}
