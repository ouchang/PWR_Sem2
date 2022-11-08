public class Temperatura {
    public double temp;
    
    public double Cejsjusz() {
        return this.temp;
    }

    public double Kelvin() {
        return this.temp + 273.15;
    }

    public double Fahrenheit() {
        return (this.temp * 9 / 5) + 32;
    }

    public void setC(double t) {
        this.temp = t;
    }

    public void setK(double t) {
        this.temp = t - 273.15;
    }

    public void setF(double t) {
        this.temp = (t-32)*5/9;
    }

    public Temperatura() {
        this.temp = 0.0;
    }

    public Temperatura(double t) {
        this.temp = t;
    }
}
