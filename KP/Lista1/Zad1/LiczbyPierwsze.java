public class LiczbyPierwsze {
    int P[]; //Tablica z liczbami pierwszymi z zakresu od 2 do n
    int k; //Ilość liczb pierwszych w zakresie od 2 do n

    //Metoda
    public int liczba(int m) {
        return P[m];
    }

    //Konstruktor
    LiczbyPierwsze(int n) {
        boolean TP[] = new boolean[n+1]; 
        
        TP[0] = false;
        TP[1] = false;
        for(int i=2; i<=n; i++) {
            TP[i] = true;
        }

        //Wyszukiwanie liczb pierwszych (Sito Eratostenesa)
        for(int i=2; i*i<=n; i++) {
            if(TP[i] == true) {
                for(int j=i*i; j<=n; j += i) {
                    TP[j] = false;
                }
            }
        }

        //Tworzenie tablicy z liczbami pierwszymi z zakresu od 2 do n
        P = new int[n]; 
        int idx = 0; //Indeks po tablicy P
        for(int i=2; i<=n; i++) {
            if(TP[i] == true) {
                P[idx] = i;
                idx++; 
            }
        }

        k = idx-1;
    }
}
