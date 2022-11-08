public class TablicaBoolTest {
    public static void main (String Args[]) {
        TablicaBool dziennik = new TablicaBool(25);
        boolean uczen;

        dziennik.Obecny(9);
        dziennik.Nieobecny(15);

        try {
            uczen = dziennik.CzyObecny(9);
            if(uczen) {
                System.out.println("UCZEN O INDEKSIE 9 JEST OBECNY");
            }

            uczen = dziennik.CzyObecny(15);
            if(uczen) {
                System.out.println("UCZEN O INDEKSIE 15 JEST OBECNY");
            }
        } catch(MojWyjatek ex) {
            System.out.println("Podano bledny indeks ucznia");
        }

        try {
            uczen = dziennik.CzyObecny(89);
        } catch(MojWyjatek ex) {
            System.out.println("Podano bledny indeks ucznia");
        }
    }
}
