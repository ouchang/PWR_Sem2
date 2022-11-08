import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;

//Wyjątek
class BlednyZakres extends Exception {}

//Zamykanie okna
class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
//
//PROTOTYP

class MyFrame extends Frame {
    //Komponenty
    Label wynik;

    MyFrame(int n) throws BlednyZakres { //n - rozmiar trojkąta
        super("Trojkąt Pascala"); //Tytuł Frame'a

        if(n < 0) throw new BlednyZakres(); //Obsługa wyjątku
        
        setBounds(n*100,n*100,n*100,n*100); //Ustawiam rozmiar Frame'a

        //Obsługa zamykania okna
        addWindowListener(new MyWindowAdapter());

        //Ustawienie Layout'u
        this.setLayout(new GridLayout(0,1));

        //Tworzę Trójkąt Pascala do n-tego wiersza włącznie
        int Tablica[][] = new int[n+1][n+1];
        String S = ""; //Tekst Labela
        
        //Obsługa dla wiersza 0 w trojkącie Pascala
        Tablica[0][0] = 1;
        S += Integer.toString(Tablica[0][0]) + "\n";
        wynik = new Label(S);
        wynik.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        wynik.setAlignment(Label.CENTER);
        add(wynik);

        //Obsługa dalszych wierszy w trojkącie Pascala
        for(int i=1; i<=n; i++) {
            S = "";
            wynik = new Label();
            Tablica[i][0] = 1;
            S += Integer.toString(Tablica[i][0]) + " ";
            for(int j=1; j<=i; j++) {
                Tablica[i][j] = Tablica[i-1][j-1] + Tablica[i-1][j]; 
                if(j < i) {
                    S += Integer.toString(Tablica[i][j]) + " ";
                } else {
                    S += Integer.toString(Tablica[i][j]) + "\n";
                }
            }

            wynik.setText(S);
            wynik.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            wynik.setAlignment(Label.CENTER);
            add(wynik);
        }
    }
}

public class TrojkatPascala {
    public static void main(String[] args) {
        int n;
        
        try {
            n = Integer.parseInt(args[0]);
            
            MyFrame frame = new MyFrame(n);
            frame.setVisible(true);
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " - błędny rozmiar trójkąta Pascala");
        } catch (BlednyZakres e) {
            System.out.println(args[0] + " - błędny zakres rozmiaru trójkąta Pascala");
        }
    }
}
