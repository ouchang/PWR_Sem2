public class TemperaturaTest {
    public static void main(String Args[]) {
        Temperatura t = new Temperatura();
        Temperatura t2 = new Temperatura(33.4);

        System.out.println("Temperatura w Celsjuszach: " + t2.Cejsjusz() + " w Kelvnach: " + t2.Kelvin() + " w Fahrenhaitach: " + t2.Fahrenheit());
        t.setC(16.5);
        System.out.println("Temperatura w Celsjuszach: " + t.Cejsjusz() + " w Kelvnach: " + t.Kelvin() + " w Fahrenhaitach: " + t.Fahrenheit());
    }
}
