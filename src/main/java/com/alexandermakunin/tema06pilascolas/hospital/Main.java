package com.alexandermakunin.tema06pilascolas.hospital;

import java.util.Scanner;

public class Main {
    public static final int numConsulta = 5;
    public static final int numPacientes = 5;
    public static Scanner leer = new Scanner(System.in);
    public static Test test = new Test();
    public static Hospital hospital = test.crearHospital(numConsulta,numPacientes);


    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int seleccion;
        do {
            System.out.println("=== HOSPITAL ===");
            System.out.println("1. Añadir paciente");
            System.out.println("2. Atender siguiente paciente");
            System.out.println("3. Mostrar estado de las colas");
            System.out.println("4. Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoPaciente();
                case 2 -> atenderPaciente();
                case 3 -> mostrarEstado();
            }
        } while (seleccion != 4);
    }
    private static void nuevoPaciente() {
        mostrarEstado();
        System.out.println("Indique que cola");
        int seleccion;
        seleccion = Integer.parseInt(leer.nextLine());
        if (seleccion < 0 || seleccion > numConsulta) {
            System.err.println("cola no valida");
        } else {
            datosPaciente(seleccion);
        }
    }

    private static void datosPaciente(int numConsulta) {
        System.out.println("Indique el nombre");
        String nombre = leer.nextLine();
        System.out.println("Indique el SIP");
        String sip = leer.nextLine();
        Paciente paciente = new Paciente(nombre,sip);
        hospital.getCola()[numConsulta].getPacienteCola().push(paciente);
        System.out.println(hospital.getCola()[numConsulta]);
    }

    private static void atenderPaciente() {
        mostrarEstado();
        System.out.println("Indique que cola");
        int seleccion;
        seleccion = Integer.parseInt(leer.nextLine());
        if (seleccion < 0 || seleccion > numConsulta) {
            System.err.println("cola no valida");
        } else {
            System.out.println("Paciente " + hospital.getCola()[seleccion].getPacienteCola().pop() + " atendido");
            System.out.println(hospital.getCola()[seleccion]);
        }
    }

    private static void mostrarEstado() {
        for (int i = 0; i < hospital.getCola().length;i++) {
            System.out.println(hospital.getCola()[i]);
        }
    }
}

