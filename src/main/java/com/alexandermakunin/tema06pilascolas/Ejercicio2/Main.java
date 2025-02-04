package com.alexandermakunin.tema06pilascolas.Ejercicio2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        System.out.println("Pila vacía: " + pila.isEmpty());

        Random aleatorio = new Random();

        double poppedValue;

        for (int i = 0; i < 10; i++) {
            pila.push(aleatorio.nextInt(1,11));
            System.out.println(pila);
        }

        for (int i = 0; i < 10; i++) {
            poppedValue = pila.pop();
            System.out.println(poppedValue);
            System.out.println(pila);
        }

        System.out.println("Pila vacía: " + pila.isEmpty());
    }
}

