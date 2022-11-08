class ZlyZakres extends Exception {};
class ZlaDana extends Exception{};

public class WierszTrojkataPascala {
    //Atrybuty
    int Wiersz[]; //Tablica z wartościa dla i-tego wiersza
    int n; //Numer wiersza

    //Konstruktor
    WierszTrojkataPascala(int n) throws ZlaDana{
        //Nieprawidłowe dane -> WYJĄTKEK
        if(n < 0) throw new ZlaDana();

        //UWAGA: Liczba wartości w i-tym wierszu jest równa i+1

        int TrojkatPascala[][] = new int[n+1][n+1]; //
        this.n = n;

        //Tworzę Trójkąt Pascala do (n-1)-ego wiersza włącznie
        TrojkatPascala[0][0] = 1;
        for(int i=1; i<n; i++) {
            TrojkatPascala[i][0] = 1;
            for(int j=1; j<=i; j++) {
                TrojkatPascala[i][j] = TrojkatPascala[i-1][j-1] + TrojkatPascala[i-1][j]; 
            }
        }

        //Zapisuje n-ty wiersz w tablicy Wiersz
        Wiersz = new int[n+1];
        Wiersz[0] = 1;
        for(int j=1; j<=n; j++) {
            Wiersz[j] = TrojkatPascala[n-1][j-1] + TrojkatPascala[n-1][j];
        }
    }

    //Metoda
    public int wspolczynnik(int m) throws ZlyZakres {
        if((m < 0) || (m > n)) throw new ZlyZakres();
            return Wiersz[m];
    }
}
