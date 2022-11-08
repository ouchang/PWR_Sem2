#include <iostream>
#include "Temperatura.hpp"

using namespace std;

double Temperatura::Celsjusz() {
    return this->temp;
}

double Temperatura::Kelvin() {
    return this->temp + 273.15;
}

double Temperatura::Fahrenheit() {
    return (this->temp*9/5) + 32;
}

void Temperatura::setC(double t) {
    this->temp = t;
}

void Temperatura::setK(double t) {
    this->temp = t - 273.15;
}

void Temperatura::setF(double t) {
    this->temp = (t-32)*5/9;
}

Temperatura::Temperatura() {
    this->temp = 0.0;
}

Temperatura::Temperatura(double t) {
    this->temp = t;
}
