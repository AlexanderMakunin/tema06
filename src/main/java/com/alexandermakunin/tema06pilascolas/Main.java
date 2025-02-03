package com.alexandermakunin.tema06pilascolas;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        System.out.println("Pila vacía: " + pila.isEmpty());

        Random aleatorio = new Random();

        for (int i = 0; i < 3; i++) {
            pila.push(aleatorio.nextInt(1,11));
        }

        System.out.println("Pila después de agregar elementos: " + pila);

        System.out.println("Último elemento (peek): " + pila.peek());

        double poppedValue = pila.pop();
        System.out.println("Elemento eliminado (pop): " + poppedValue);
        System.out.println("Pila después de hacer pop: " + pila);

        poppedValue = pila.pop();
        System.out.println("Elemento eliminado (pop): " + poppedValue);
        System.out.println("Pila después de hacer pop: " + pila);

        double topValue = pila.top();
        System.out.println("Elemento encima (top): " + topValue);
        System.out.println("Pila después de hacer pop: " + pila);

        System.out.println("Tamaño de la pila: " + pila.size());

        poppedValue = pila.pop();
        System.out.println("Elemento eliminado (pop): " + poppedValue);

        System.out.println("Pila vacía: " + pila.isEmpty());
    }
}

