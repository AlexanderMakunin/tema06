package com.alexandermakunin.ejercicio5;

import com.alexandermakunin.ejercicio4.Punto;

public class Circunferencia {
    private Punto punto;
    private double radio;

    public Circunferencia(Punto punto, double radio) {
        this.punto = punto;
        this.radio = radio;
    }
    public Circunferencia(double x, double y,double radio) {
        this.punto = new Punto(x,y);
        this.radio = radio;
    }
    public Circunferencia() {
        this.punto = new Punto(0.0,0.0);
        this.radio = 5;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double distancia(Punto punto){
        double dx = this.punto.getX() - punto.getX();
        double dy = this.punto.getY() - punto.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    public double area(){
        return Math.PI * Math.pow(this.radio,2);
    }
    public double perimetro(){
        return 2*this.radio*Math.PI;
    }

    @Override
    public String toString() {
        if (this.punto.getX() == 0 && this.punto.getY() == 0) {
            return "Círcunferencia de radio " + radio + " cm situada en el origen de coordenadas.";
        } else {
            return "Círcunferencia de radio " + radio + " cm situada en el punto (" + punto.getX() + ", " + punto.getY() + ")";
        }
    }
}
