import java.lang.Math;

class BlednyKat extends Exception {};
class BlednyBok extends Exception {};

//Interfejs
interface Operacje {
    public double Obwod();
    public double Pole();
}

//Klasa abstrakcyjna
abstract class Figura implements Operacje {}

abstract class Czworokat extends Figura {
    //Atrybuty
    int bok1, bok2, bok3, bok4;
    int kat;

    //Metody
    public double Obwod() {
        return bok1 + bok2 + bok3 + bok4;
    }
}

class Kolo extends Figura {
    //Atrybuty
    int promien;

    //Konstruktor
    Kolo(int promien) throws BlednyBok {
        if(promien <= 0) throw new BlednyBok();
        this.promien = promien;
    }

    //Metody
    public double Obwod() {
        double pi = 3.14;
        return 2*pi*promien;
    }

    public double Pole() {
        double pi = 3.14;
        return pi*promien*promien;
    }
}

class Pieciokat extends Figura {
    //Atrybuty
    int bok;

    //Konstruktor
    Pieciokat(int bok) throws BlednyBok {
        if(bok <= 0) throw new BlednyBok();

        this.bok = bok; 
    }

    //Metody
    public double Obwod() {
        return 5*bok;
    }
    public double Pole() {
        double pierwiastek5 = Math.sqrt(5.0);
        return 0.25 * Math.sqrt(25 + 10*pierwiastek5) * bok * bok;
    }
}

class Szesciokat extends Figura {
    //Atrybuty
    int bok;

    //Konstruktor
    Szesciokat(int bok) throws BlednyBok {
        if(bok <= 0) throw new BlednyBok();

        this.bok = bok;
    }

    //Metody
    public double Obwod() {
        return 6*bok;
    }
    public double Pole() {
        double pierwiastek3 = Math.sqrt(3.0);
        return 3 * 0.5 * bok * bok * pierwiastek3;
    }
}

class Kwadrat extends Czworokat {
    //bok1 = bok2 = bok3 = bok4

    //Konstruktor
    Kwadrat(int bok1, int bok2, int bok3, int bok4, int kat) throws BlednyKat, BlednyBok {
        //Nieprawidłowe dane -> WYJĄTKEK
        if((kat > 90) || (kat < 0)) throw new BlednyKat();
        if((bok1 <= 0) || (bok2 <= 0) || (bok3 <= 0) || (bok4 <= 0)) throw new BlednyBok();

        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
        this.kat = kat;
    }

    //Metody
    public double Pole() {
        return bok1*bok1; 
    }
}

class Prostokat extends Czworokat {
    //Konstruktor
    Prostokat(int bok1, int bok2, int bok3, int bok4, int kat) throws BlednyBok, BlednyKat{
        //Nieprawidłowe dane -> WYJĄTKEK
        if((kat > 90) || (kat < 0)) throw new BlednyKat();
        if((bok1 <= 0) || (bok2 <= 0) || (bok3 <= 0) || (bok4 <= 0)) throw new BlednyBok();

        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
        this.kat = kat;
    }

    //Metody
    public double Pole() {
        if(bok1 != bok2) {
            return bok1 * bok2;
        } else { 
            return bok1 * bok3;
        }
    }
}

class Romb extends Czworokat {
    //Konstruktor
    Romb(int bok1, int bok2, int bok3, int bok4, int kat) throws BlednyBok, BlednyKat {
        //Nieprawidłowe dane -> WYJĄTKEK
        if((kat > 90) || (kat < 0)) throw new BlednyKat();
        if((bok1 <= 0) || (bok2 <= 0) || (bok3 <= 0) || (bok4 <= 0)) throw new BlednyBok();

        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
        this.kat = kat;
    }

    //Metody
    public double Pole() {
        double kat_radian = Math.toRadians(kat);
        double sin = Math.sin(kat_radian);
        return bok1 * bok2 * sin;
    }
}

public class Figury {
    public static void main(String[] args) {
        //Dane o figurach
        int bok1, bok2, bok3, bok4, kat;
        int bok;
        int promien;

        //Wyniki metod
        double pole, obwod;

        int liczbaFigur = args[0].length();
        char[] typyFigur = args[0].toCharArray();

        //Analiza typyFigur i zliczanie prawdidłowej liczby parametrów
        int prawdlowaLiczbaArgs = 0;
        for(int i=0; i<typyFigur.length; i++) {
            if(typyFigur[i] == 'c')
                prawdlowaLiczbaArgs += 5; //4 boki i kat
            else if((typyFigur[i] == 'o') || (typyFigur[i] == 'p') || (typyFigur[i] == 's'))
                prawdlowaLiczbaArgs++;
            else {
                System.out.println(typyFigur[i] + " - błędny typ figury");
                return;
            }
        }

        //Sprawdzenie czy nie brakuje jakichś parametrów
        if(prawdlowaLiczbaArgs != args.length-1) {
            System.out.println("Nieprawidłowa liczba parametrów");
            return;
        }

        //Tworzę tablicę z obiektami figur
        Figura F[] = new Figura[liczbaFigur];

        //Wczytywanie parametrów figur
        int type_idx=0;
        int ti=0;
        for(int i=1; i<=args.length; i++) {
            if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'c')) {
                ti = i;

                //Zwiększam indeks i tak, by wskazywał na początek danych kolejnej figury
                i += 4; //bo jeszcze indeks i zostanie zwiększony o 1 po przejście tej iteracji

                //CZWOROKĄT
                try {
                    bok1 = Integer.parseInt(args[ti]);
                    //Zwiększam indeks i, by przesunać się do kolejnego parametru
                    ti++;

                    bok2 = Integer.parseInt(args[ti]);
                    ti++;

                    bok3 = Integer.parseInt(args[ti]);
                    ti++;

                    bok4 = Integer.parseInt(args[ti]);
                    ti++;

                    kat = Integer.parseInt(args[ti]);
                } catch(NumberFormatException e) {
                    System.out.println(args[ti] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                }

                //Sprawdzam jaki mamy czworokąt
                if((bok1 == bok2) && (bok1 == bok3) && (bok1 == bok4) && (kat == 90)) {
                    //KWADRAT

                    //Tworzę odpowiedni obiekt do danej figury
                    try{ 
                        F[type_idx] = new Kwadrat(bok1, bok2, bok3, bok4, kat);

                        //Uruchamiam metody
                        obwod = F[type_idx].Obwod();
                        pole = F[type_idx].Pole();

                        //Wyświetlanie
                        System.out.println("KWADRAT");
                        System.out.println("Obwód: " + obwod);
                        System.out.println("Pole: " + pole);

                        type_idx++;
                    } catch (BlednyKat e) {
                       System.out.println(kat + " - liczba spoza zakresu");
                       type_idx++;
                       continue;
                    } catch (BlednyBok e) {
                       System.out.println("Bok spoza zakresu!");
                       type_idx++;
                       continue;
                    }

                } else if((bok1 == bok2) && (bok1 != bok3) && (bok3 == bok4)) {
                    //PROSTOKĄT
                    try{ 
                        F[type_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);

                        //Uruchamiam metody
                        obwod = F[type_idx].Obwod();
                        pole = F[type_idx].Pole();

                        //Wyświetlanie
                        System.out.println("PROSTOKAT");
                        System.out.println("Obwód: " + obwod);
                        System.out.println("Pole: " + pole);

                        type_idx++;
                    } catch (BlednyKat e) {
                       System.out.println(kat + " - liczba spoza zakresu");
                       type_idx++;
                       continue;
                    } catch (BlednyBok e) {
                        System.out.println("Bok spoza zakresu!");
                        type_idx++;
                        continue;
                     }
                } else if((bok1 == bok3) && (bok1 != bok2) && (bok2 == bok4)) {
                    //PROSTOKĄT
                    try{ 
                        F[type_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);
                        
                        //Uruchamiam metody
                        obwod = F[type_idx].Obwod();
                        pole = F[type_idx].Pole();

                        //Wyświetlanie
                        System.out.println("PROSTOKAT");
                        System.out.println("Obwód: " + obwod);
                        System.out.println("Pole: " + pole);

                        type_idx++;
                    } catch (BlednyKat e) {
                       System.out.println(kat + " - liczba spoza zakresu");
                       type_idx++;
                       continue;
                    }  catch (BlednyBok e) {
                        System.out.println("Bok spoza zakresu!");
                        type_idx++;
                        continue;
                    }
                } else if((bok1 == bok4) && (bok1 != bok2) && (bok2 == bok3)) {
                    //PROSTOKĄT
                    try{ 
                        F[type_idx] = new Prostokat(bok1, bok2, bok3, bok4, kat);
                        
                        //Uruchamiam metody
                        obwod = F[type_idx].Obwod();
                        pole = F[type_idx].Pole();

                        //Wyświetlanie
                        System.out.println("PROSTOKAT");
                        System.out.println("Obwód: " + obwod);
                        System.out.println("Pole: " + pole);

                        type_idx++;
                    } catch (BlednyKat e) {
                       System.out.println(kat + " - liczba spoza zakresu");
                       type_idx++;
                       continue;
                    } catch (BlednyBok e) {
                        System.out.println("Bok spoza zakresu!");
                        type_idx++;
                        continue;
                    }
                } else if((bok1 == bok2) && (bok1 == bok3) && (bok1 == bok4)) {
                    //ROMB
                    try{ 
                        F[type_idx] = new Romb(bok1, bok2, bok3, bok4, kat);
                        
                        //Uruchamiam metody
                        obwod = F[type_idx].Obwod();
                        pole = F[type_idx].Pole();

                        //Wyświetlanie
                        System.out.println("ROMB");
                        System.out.println("Obwód: " + obwod);
                        System.out.println("Pole: " + pole);

                        type_idx++;
                    } catch (BlednyKat e) {
                       System.out.println(kat + " - liczba spoza zakresu");
                       type_idx++;
                       continue;
                    } catch (BlednyBok e) {
                        System.out.println("Bok spoza zakresu!");
                        type_idx++;
                        continue;
                    }
                } else {
                    System.out.println("Nie rozpoznano figury!");
                    type_idx++;
                }

                
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'p')) { 
                //PIĘCIOKĄT
                try {
                    bok = Integer.parseInt(args[i]);
                    F[type_idx] = new Pieciokat(bok);

                    //Uruchamiam metody
                    obwod = F[type_idx].Obwod();
                    pole = F[type_idx].Pole();

                    //Wyświetlanie
                    System.out.println("PIECIOKAT");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch(NumberFormatException e) {
                    System.out.println(args[i] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                } catch (BlednyBok e) {
                    System.out.println(args[i] + " - liczba spoza zakresu");
                    type_idx++;
                    continue;
                }
            } else if((type_idx < typyFigur.length) && typyFigur[type_idx] == 's') {
                //SZESCIOKAT
                try {
                    bok = Integer.parseInt(args[i]);
                    F[type_idx] = new Szesciokat(bok);

                    //Uruchamiam metody
                    obwod = F[type_idx].Obwod();
                    pole = F[type_idx].Pole();

                    //Wyświetlanie
                    System.out.println("SZESCIOKAT");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch(NumberFormatException e) {
                    System.out.println(args[i] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                } catch (BlednyBok e) {
                    System.out.println(args[i] + " - liczba spoza zakresu");
                    type_idx++;
                    continue;
                }
            } else if((type_idx < typyFigur.length) && typyFigur[type_idx] == 'o') { 
                //KOŁO
                try {
                    promien = Integer.parseInt(args[i]);
                    F[type_idx] = new Kolo(promien);

                    //Uruchamiam metody
                    obwod = F[type_idx].Obwod();
                    pole = F[type_idx].Pole();

                    //Wyświetlanie
                    System.out.println("KOLO");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch(NumberFormatException e) {
                    System.out.println(args[i] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                } catch (BlednyBok e) {
                    System.out.println(args[i] + " - liczba spoza zakresu");
                    type_idx++;
                    continue;
                }
            }
        }
    }
}
