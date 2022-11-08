public class Podzielnik {
    public static void main(String[] args) {
        int n=0;
        int dzielnik=0;

        for(int i=0; i<args.length; i++) {
            try {n=Integer.parseInt(args[i]);
                dzielnik = div(n);
                System.out.println(dzielnik);
            } catch (NumberFormatException ex) {
                System.out.println(args[i] + " nie jest liczba calkowita");
            }
        }
    }

    public static int div(int n) { //zwraca najwiekszy podzielnik niebedacy n
        if(n == 0) {
            return 0;
        }

        int tn = n;
        if(tn < 0) {
            tn *= (-1);
        }
        
        int i=1;
        int max_dzielnik=0;
        while(i < tn) {
            if(tn % i == 0) {
                if(max_dzielnik < i)
                    max_dzielnik = i;
                else if(max_dzielnik < (tn/i) && (i != 1)) 
                    max_dzielnik = tn/i;
            }

            i++;
        }

        return max_dzielnik;
    }
    
}
