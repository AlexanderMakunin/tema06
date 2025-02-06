package com.alexandermakunin.tema06pilascolas.hospital;

import java.util.Scanner;

public class Main {

    public static Scanner leer = new Scanner(System.in);
    public static Hospital hospital = new Hospital();
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int seleccion;
        do {
            System.out.println("=== HOSPITAL ===");
            System.out.println("1.Añadir paciente");
            System.out.println("2.Atender siguiente paciente");
            System.out.println("3.Mostrar estado de las colas");
            System.out.println("4.Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoPaciente();
                case 2 -> Atender();
                case 3 -> mostrarEstado();
                case 5 -> pruebas();
            }
        } while (seleccion != 4);
    }

    private static void nuevoPaciente() {
        System.out.println(hospital);
    }

    private static void Atender() {
        System.out.println(hospital);
    }

    private static void mostrarEstado() {
        System.out.println(hospital);
    }

    private static void pruebas() {
        System.out.println(hospital);
    }


}

