package com.alexandermakunin.tema06pilascolas;

import com.alexandermakunin.tema06pilascolas.Ejercicio2.Pila;

import java.util.Scanner;

public class Ejercicio3 {
    public static Scanner leer = new Scanner(System.in);
    public static Pila stack = new Pila();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        System.out.println("Introduzca su codigo");
        String codigo = leer.nextLine();

        if (!stack.empty()) {
            System.err.println("Tu codigo esta mal");
        } else {
            System.out.println("Esta bien el codigo");
        }
    }
}
