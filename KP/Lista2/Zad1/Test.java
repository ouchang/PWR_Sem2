public class Test {
    public static void main(String[] args) {
        WierszTrojkataPascala W; //n-ty wiersz
        int n, x, a;

        //Tworzenie n-tego wiersza trójkąta Pascala
        try {
            n = Integer.parseInt(args[0]);
            W = new WierszTrojkataPascala(n);
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        } catch (ZlaDana e) {
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }

        //Analiza zapytań o x-ową liczbę w wierszu
        for(int i=1; i<args.length; i++) {
            try { 
                x = Integer.parseInt(args[i]);

                a = W.wspolczynnik(x);
                System.out.println(args[i] + " - " + a);

            } catch (NumberFormatException e) {
                System.out.println(args[i] + " - nieprawidłowa dana");
            }  catch (ZlyZakres e) {
                System.out.println(args[i] + " - liczba spoza zakresu");
            } 
        }
    }
}
//Limit górny dla int'a: 2 147 483 647
//Maksymalny wiersz trójkąta Pascala, jaki można wyznaczyć w tablicy int, to wiersz 33
//bo dla wiersza 34, 34 po 16 = 2 203 961 430
