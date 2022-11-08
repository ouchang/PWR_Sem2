public class Test {
    public static void main(String[] args) {
        LiczbyPierwsze T; //Tablica z l. pierwszymy z zakresu od 2 do n
        int n, x, p;

        //Tworzenie tablicy z l. pierwszymi z zakresu od 2 do n
        try { 
            n = Integer.parseInt(args[0]);
            if(n < 2) {
                System.out.println(args[0] + " - nieprawidłowy zakres");
                return;
            }
            T = new LiczbyPierwsze(n);
        } catch (NumberFormatException ex) {
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }
 
        //Analiza zapytań o x-ową liczbę pierwszą
        for(int i=1; i<args.length; i++) {
            try { 
                x = Integer.parseInt(args[i]);

                //Sprawdzenie czy zapytanie X mieści się
                //w zakresie znalezionych liczb pierwszych
                if((x >= 0) && (x <= T.k)) {
                    p = T.liczba(x);
                    System.out.println(args[i] + " - " + p);
                } else {
                    System.out.println(args[i] + " - liczba spoza zakresu");
                }

            } catch (NumberFormatException ex) {
                System.out.println(args[i] + " - nieprawidłowa dana");
            }   
        }

    }
}
