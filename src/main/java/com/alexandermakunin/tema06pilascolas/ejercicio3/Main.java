package com.alexandermakunin.tema06pilascolas.ejercicio3;

import com.alexandermakunin.tema06pilascolas.Ejercicio2.Pila;

import java.util.Scanner;

public class Main {
    public static Scanner leer = new Scanner(System.in);
    public static PilaString stack = new PilaString();
    public static void main(String[] args) {
        System.out.println("Introduzca su codigo");
        String codigo = leer.nextLine();
        boolean comprobar = true;
        char algo;
        for (int i = 0; i < codigo.length(); i++) {
            algo = codigo.charAt(i);
            switch (algo) {
                case '{' -> stack.push("{");
                case '[' -> stack.push("[");
                case '(' -> stack.push("(");
            }
            System.out.println(stack.toString());
            if (algo == '}') {
                System.out.println(stack);
                System.out.println(stack.pop());
            } else if (algo == ')') {
                System.out.println(stack);
                System.out.println(stack.pop().equals("("));
            }
        }
    }
}
