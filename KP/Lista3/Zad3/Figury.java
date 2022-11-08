import java.lang.Math;

class BlednyKat extends Exception {};
class BlednyBok extends Exception {};

interface Operacje1Parametr {
    public double ObliczPole(int bok) throws BlednyBok;
    public double ObliczObwod(int bok) throws BlednyBok;
}

interface Operacje2Parametry {
    double ObliczPole(int bok, int x) throws BlednyBok, BlednyKat;
    double ObliczObwod(int bok, int x) throws BlednyBok;
    //X to w zależności od figury: kąt lub bok2
}

public class Figury {
    
    public enum Figura1 implements Operacje1Parametr {
        KWADRAT {
            public double ObliczObwod(int bok) throws BlednyBok{
                if(bok <= 0) throw new BlednyBok();
                return 4*bok;
            }

            public double ObliczPole(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                return bok*bok;
            }
        },
        KOLO {
            public double ObliczObwod(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                return 2*3.14*bok; //tutaj bok == promien
            }

            public double ObliczPole(int bok) {
                return 3.14*bok*bok; //tutaj bok == promien
            }
        },
        PIECIOKAT {
            public double ObliczObwod(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                return 5*bok;
            }

            public double ObliczPole(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                double pierwiastek5 = Math.sqrt(5.0);
                return 0.25 * Math.sqrt(pierwiastek5*10 + 25) * bok * bok;
            }
        },
        SZESCIOKAT {
            public double ObliczObwod(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                return 6*bok;
            }

            public double ObliczPole(int bok) throws BlednyBok {
                if(bok <= 0) throw new BlednyBok();
                double pierwiastek3 = Math.sqrt(3.0);
                return 3 * pierwiastek3 * 0.5 * bok * bok;
            }
        };
    }

    public enum Figura2 implements Operacje2Parametry {
        PROSTOKAT {
            public double ObliczObwod(int bok1, int bok2) throws BlednyBok {
                if(bok1 <= 0 || bok2 <= 0) throw new BlednyBok();
                return 2*bok1+2*bok2;
            }

            public double ObliczPole(int bok1, int bok2) throws BlednyBok {
                if(bok1 <= 0 || bok2 <= 0) throw new BlednyBok();
                return bok1 * bok2;
            }
        },
        ROMB {
            public double ObliczObwod(int bok, int kat) throws BlednyBok{
                if(bok <= 0) throw new BlednyBok();
                return 4*bok;
            }

            public double ObliczPole(int bok, int kat) throws BlednyBok, BlednyKat {
                if(bok <= 0) throw new BlednyBok();
                if(kat <= 0 || kat > 90) throw new BlednyKat();
                double tkat= kat * 3.14 / 180; //Konwersja stopni na radiany
                return bok * bok * Math.sin(tkat);
            }
        };
    }

    //OZNACZENIA FIGUR
    //o - koło
    //r - romb
    //p - pieciokat
    //s - szesciokat
    //P - prostokat
    //k - kwadrat


    public static void main(String args[]) {
        //Dane o figurach
        int bok=0, bok2=0, kat=0;
        int promien=0;

        //Wyniki metod
        double pole=0, obwod=0;

        int liczbaFigur = args[0].length();
        char[] typyFigur = args[0].toCharArray();

        //Analiza typyFigur
        int prawdlowaLiczbaArgs = 0;
        for(int i=0; i<liczbaFigur; i++) {
            if(typyFigur[i] == 'P' || typyFigur[i] == 'r')
                prawdlowaLiczbaArgs += 2; //
            else if((typyFigur[i] == 'o') || (typyFigur[i] == 'p') || (typyFigur[i] == 's') || (typyFigur[i] == 'k'))
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

        //Wczytywanie parametrów figur
        int type_idx=0;
        int ti=0;

        Figura2 a;
        Figura1 b;

        for(int i=1; i<=args.length; i++) {
            if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'r')) {
                //ROMB

                ti = i;
                //Zwiększam indeks i tak, by wskazywał na początek danych kolejnej figury
                i += 1; //bo jeszcze indeks i zostanie zwiększony o 1 po przejście tej iteracji

                try {
                    bok = Integer.parseInt(args[ti]);
                    //Zwiększam indeks i, by przesunać się do kolejnego parametru
                    ti++;

                    kat = Integer.parseInt(args[ti]);

                    a = Figury.Figura2.ROMB;
                        
                    //Uruchamiam metody
                    obwod = a.ObliczObwod(bok, kat);
                    pole = a.ObliczPole(bok, kat);

                    //Wyświetlanie
                    System.out.println("ROMB");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch(NumberFormatException e) {
                    System.out.println(args[ti] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                }  catch (BlednyBok e) {
                    System.out.println("Bok spoza zakresu!");
                    type_idx++;
                    continue;
                } catch (BlednyKat e) {
                    System.out.println(kat + " - liczba spoza zakresu");
                    type_idx++;
                    continue;
                } 
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'P')) {
                //PROSTOKĄT
                ti = i;
                //Zwiększam indeks i tak, by wskazywał na początek danych kolejnej figury
                i += 1; //bo jeszcze indeks i zostanie zwiększony o 1 po przejście tej iteracji

                try {
                    bok = Integer.parseInt(args[ti]);
                    //Zwiększam indeks i, by przesunać się do kolejnego parametru
                    ti++;

                    bok2 = Integer.parseInt(args[ti]);

                    a = Figury.Figura2.PROSTOKAT;
                        
                    //Uruchamiam metody
                    obwod = a.ObliczObwod(bok, bok2);
                    pole = a.ObliczPole(bok, bok2);

                    //Wyświetlanie
                    System.out.println("PROSTOKAT");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch(NumberFormatException e) {
                    System.out.println(args[ti] + " - nieprawidłowa dana");
                    type_idx++;
                    continue;
                }  catch (BlednyBok e) {
                    System.out.println("Bok spoza zakresu!");
                    type_idx++;
                    continue;
                }  catch (BlednyKat e) {
                    System.out.println(kat + " - liczba spoza zakresu");
                    type_idx++;
                    continue;
                }
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'o')) {
                //KOŁO
                try {
                    promien = Integer.parseInt(args[i]);
                    b = Figury.Figura1.KOLO;

                    //Uruchamiam metody
                    obwod = b.ObliczObwod(promien);
                    pole = b.ObliczPole(promien);

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
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'p')) {
                //PIECIOKAT
                try {
                    bok = Integer.parseInt(args[i]);
                    b = Figury.Figura1.PIECIOKAT;

                    //Uruchamiam metody
                    obwod = b.ObliczObwod(bok);
                    pole = b.ObliczPole(bok);

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
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 's')) {
                //SZESCIOKAT
                try {
                    bok = Integer.parseInt(args[i]);
                    b = Figury.Figura1.SZESCIOKAT;

                    //Uruchamiam metody
                    obwod = b.ObliczObwod(bok);
                    pole = b.ObliczPole(bok);

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
            } else if((type_idx < typyFigur.length) && (typyFigur[type_idx] == 'k')) {
                try{ 
                    bok = Integer.parseInt(args[i]);
                    b = Figury.Figura1.KWADRAT;

                    //Uruchamiam metody
                    obwod = b.ObliczObwod(bok);
                    pole = b.ObliczPole(bok);

                    //Wyświetlanie
                    System.out.println("KWADRAT");
                    System.out.println("Obwód: " + obwod);
                    System.out.println("Pole: " + pole);

                    type_idx++;
                } catch (BlednyBok e) {
                   System.out.println("Bok spoza zakresu!");
                   type_idx++;
                   continue;
                }
            }
        }
    }
}


