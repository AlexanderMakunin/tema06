package com.alexandermakunin.ejercicio5;

import com.alexandermakunin.ejercicio4.Punto;

public class Principal {
    public static void main(String[] args) {
        Circunferencia circ1 = new Circunferencia(new Punto(3.2, 4.0), 2.5);
        Circunferencia circ2 = new Circunferencia(new Punto(0.0, 0.0), 3.2);
        Circunferencia circ3 = new Circunferencia(new Punto(1.0, 2.0), 4.0);

        System.out.println(circ1);
        System.out.println("Perímetro: " + circ1.perimetro() + " cm");
        System.out.println("Área: " + circ1.area() + " cm²");
        System.out.println();

        System.out.println(circ2);
        System.out.println("Perímetro: " + circ2.perimetro() + " cm");
        System.out.println("Área: " + circ2.area() + " cm²");
        System.out.println();

        System.out.println(circ3);
        System.out.println("Perímetro: " + circ3.perimetro() + " cm");
        System.out.println("Área: " + circ3.area() + " cm²");
        System.out.println();

        System.out.println("Distancia entre circ1 y circ2: " + circ1.distancia(circ2.getPunto()) + " cm");
        System.out.println("Distancia entre circ1 y circ3: " + circ1.distancia(circ3.getPunto()) + " cm");
    }
}
