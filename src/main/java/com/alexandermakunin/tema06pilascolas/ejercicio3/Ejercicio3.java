package com.alexandermakunin.tema06pilascolas.ejercicio3;

import com.alexandermakunin.tema06pilascolas.Ejercicio2.Pila;

import java.util.Scanner;

public class Ejercicio3 {
    public static Scanner leer = new Scanner(System.in);
    public static PilaString stack = new PilaString();
    public static void main(String[] args) {
        System.out.println("Introduzca su codigo");
        String codigo = leer.nextLine();
        boolean comprobar = true;
        char algo;
        for (int i = 0; i < codigo.length(); i++) {
            algo = codigo.charAt(i);
            System.out.println(stack.toString());

            switch (algo) {
                case '{':
                    stack.push("{");
                    break;
                case '[':
                    stack.push("[");
                    break;
                case '(':
                    stack.push("(");
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop().equals("{")) {
                    } else {
                        System.err.println("Está mal hecho: mismatched '}'");
                        comprobar = false;
                        break;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.pop().equals("(")) {
                    } else {
                        System.err.println("Está mal hecho: mismatched ')'");
                        comprobar = false;
                        break;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.pop().equals("[")) {
                    } else {
                        System.err.println("Está mal hecho: mismatched ']'");
                        comprobar = false;
                        break;
                    }
                    break;
            }

            if (!comprobar) break;
        }

        if (stack.isEmpty() && comprobar) {
            System.out.println("Está bien codeado");
        } else {
            System.err.println("Algo salió mal: los paréntesis no están balanceados.");
        }
    }
}
