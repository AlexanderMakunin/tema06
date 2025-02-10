package com.alexandermakunin.tema06pilascolas.hospital;

import java.util.Scanner;

public class Main {
    public static Hospital hospital = new Hospital();
    public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int seleccion;
        do {
            System.out.println("=== HOSPITAL ===");
            System.out.println("1. Añadir paciente\n");
            System.out.println("2. Atender siguiente paciente ===");
            System.out.println("3. Mostrar estado de las colas");
            System.out.println("4. Salir");
            System.out.println("5. Prueba");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoPaciente();
                case 2 -> atenderPaciente();
                case 3 -> mostrarEstado();
                case 5 -> prueba();
            }
        } while (seleccion != 4);
    }
    private static void nuevoPaciente() {
        System.out.println(hospital);
        int seleccion;
        do {
            System.out.println("Que cola? (0 para salir)");
            seleccion = Integer.parseInt(leer.nextLine());
        } while (seleccion != 0);
    }

    private static void atenderPaciente() {

    }

    private static void mostrarEstado() {

    }

    private static void prueba() {

    }
}

