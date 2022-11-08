class MojWyjatek extends Exception {}

public class TablicaBool {
    boolean[] tab;
    int liczbaUczniow;

    TablicaBool(int l) {
        this.liczbaUczniow = l;
        tab = new boolean[l];
    }

    void Obecny(int idx) {
        this.tab[idx] = true;
    }


    void Nieobecny(int idx) {
        this.tab[idx] = false;
    }

    boolean CzyObecny(int idx) throws MojWyjatek {
        if(idx > liczbaUczniow || idx < 1) throw new MojWyjatek();
        if(tab[idx]) {
            return true;
        }
        return false;
    }
}
