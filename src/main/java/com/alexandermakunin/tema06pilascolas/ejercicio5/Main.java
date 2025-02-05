package com.alexandermakunin.tema06pilascolas.ejercicio5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        System.out.println("Pila vacía: " + pila.isEmpty());

        Random aleatorio = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(aleatorio.nextInt(1,11));
            if (aleatorio.nextBoolean()) {
                if (aleatorio.nextBoolean()) {
                    sb.append("+");
                } else {
                    sb.append("-");
                }
            } else {
                if (aleatorio.nextBoolean()) {
                    sb.append("*");
                } else {
                    sb.append("/");
                }
            }
            sb.append(aleatorio.nextInt(1,11));
        }

        String algo;
        for (int i = 0; i < sb.length(); i++) {
            algo = "" + sb.charAt(i);
        }

        System.out.println("Pila vacía: " + pila.isEmpty());
    }
}

