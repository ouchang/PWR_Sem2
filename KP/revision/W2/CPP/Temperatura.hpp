#pragma once

using namespace std;

class Temperatura {
    private:
        double temp;
    
    public:
        double Celsjusz();
        double Kelvin();
        double Fahrenheit();
        void setC(double t);
        void setK(double t);
        void setF(double t);
        Temperatura();
        Temperatura(double t);
};
