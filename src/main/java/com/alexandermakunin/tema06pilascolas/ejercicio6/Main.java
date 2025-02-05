package com.alexandermakunin.tema06pilascolas.ejercicio6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();

        System.out.println("Pila vacía: " + cola.isEmpty());

        Random aleatorio = new Random();

        double poppedValue;

        for (int i = 0; i < 10; i++) {
            cola.push(aleatorio.nextInt(1,11));
            System.out.println(cola);
        }

        for (int i = 0; i < 10; i++) {
            poppedValue = cola.pop();
            System.out.println(poppedValue);
            System.out.println(cola);
        }

        System.out.println("Pila vacía: " + cola.isEmpty());
    }
}

