package com.alexandermakunin.ejercicio7;

import java.util.Scanner;

public class Main {
    public static Hospital hospital = new Hospital();
    public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        int seleccion;
        do {

            System.out.println("** URGENCIAS **");
            System.out.println("********************");
            System.out.println("1. Nuevo paciente …" );
            System.out.println("2. Atender paciente …" );
            System.out.println("3. Consultas …" );
            System.out.println("4. Alta médica …");
            System.out.println("-----------------------------" );
            System.out.println("0. Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoPaciente();
                case 2 -> atenderPaciente();
                case 3 -> consultas();
                case 4 -> altaMedica();
            }
        } while (seleccion != 0);
    }
    public static void nuevoPaciente() {
        System.out.println("Indique el sip");
        int sip = Integer.parseInt(leer.nextLine());
        boolean check = hospital.nuevoPaciente(sip);
        if (check) {
            System.out.println("Ese paciente ya esta siendo atendido");
            return;
        }
        System.out.println("Indique el nombre");
        String nombre = leer.nextLine();
        System.out.println("Indique el genero (V o M)");
        String sexo = leer.nextLine();
        Pacientes.sexo sex = Pacientes.sexo.valueOf(sexo);
        System.out.println("Indique la edad");
        int edad = Integer.parseInt(leer.nextLine());
        System.out.println("Indique la sintologia");
        String sintomatologia = leer.nextLine();
        check = hospital.nuevoPaciente2(sip,nombre,sex,edad,sintomatologia);
        if (check) {
            System.out.println("Paciente añadido exitosamente");
        } else {
            System.out.println("No se pudo realizarlo");
        }
    }
    public static void atenderPaciente() {
        System.out.println("Indique el SIP");
        int sip = Integer.parseInt(leer.nextLine());
        Pacientes paciente = hospital.buscarPaciente(sip);
        if (paciente != null) {

        }
    }
    public static void consultas() {

    }
    public static void altaMedica() {

    }
}
