class Samochod {
    public String nazwa;
    public String nr_rejestracji;

    public double ObliczSpalanie(int km) {
        double spalanie = 5.6;
        return km * spalanie;
    };
}

class SamochodOsobowy extends Samochod {
    public double spalanie;

    public double ObliczSpalanie(int km) {
        return this.spalanie * km;
    };
}

public class mainj {
    public static void main(String Arg[]) {
        Samochod s1 = new Samochod();
        SamochodOsobowy s2 = new SamochodOsobowy();
        Samochod s3 = new SamochodOsobowy();

        s1.nazwa = "Fiat Punto 33";
        s1.nr_rejestracji = "DOP4564";

        s2.nazwa = "Toyota Corolla 12";
        s2.spalanie = 4.6;

        s3.nazwa = "Suzuki Swift 35";

        double spalanie = s1.ObliczSpalanie(50);
        System.out.println("SPALANIE: " + spalanie);

        spalanie = s2.ObliczSpalanie(50);
        System.out.println("SPALANIE: " + spalanie);

        System.out.println("NAZWA: " + s1.nazwa);
        System.out.println("NAZWA: " + s2.nazwa);
        System.out.println("NAZWA: " + s3.nazwa);
    }
}

