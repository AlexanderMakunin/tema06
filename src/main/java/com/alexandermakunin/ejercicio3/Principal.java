package com.alexandermakunin.ejercicio3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static final int MAX_ALUMNOS = 100;
    public static Alumnos[] alumnos = new Alumnos[MAX_ALUMNOS];
    public static void main(String[] args) {
        int seleccion;
        do {
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno …");
            System.out.println("2. Baja de alumno …");
            System.out.println("3. Consultas …");
            System.out.println("4. Pruebas …");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoAlumno();
                case 2 -> bajaAlumno();
                case 3 -> consultas();
                case 4 -> pruebas();
            }
        } while (seleccion != 0);
    }
    public static void nuevoAlumno() {
        System.out.println("Indique el NIA");
        String NIA = leer.nextLine();
        for (int i = 0; i < alumnos.length-1; i++) {
            if (alumnos[i] != null && alumnos[i].getNia().equals(NIA)) {
                System.out.println("El NIA ya está registrado.");
                return;
            }
        }
        System.out.println("Indique el nombre");
        String nombre = leer.nextLine();
        System.out.println("Indique los apellidos");
        String apellidos = leer.nextLine();
        System.out.println("Indique la fecha de nacimiento usando este estandar XX-XX-XXXX");
        String nacimiento = leer.nextLine();
        System.out.println("Indique el grupo de clase");
        String grupo = leer.nextLine();
        System.out.println("Indique el numero de telefono");
        int telefono = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < alumnos.length-1; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumnos(NIA, nombre, apellidos, nacimiento, grupo, telefono);
                System.out.println("Alumno registrado exitosamente.");
                return;
            }
        }
        System.out.println("No hay espacio disponible para más alumnos.");
    }
    public static void bajaAlumno() {
        System.out.println("Indique el NIA");
        String NIA = leer.nextLine();
        for (int i = 0; i < alumnos.length-1; i++) {
            if (alumnos[i] != null && alumnos[i].getNia().equals(NIA)) {
                alumnos[i] = null;
                break;
            }
        }
    }
    public static void consultas() {
        int seleccion;
        do {
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("***************");
            System.out.println("1. Por grupo …");
            System.out.println("2. Por edad ...");
            System.out.println("3. Por nia ...");
            System.out.println("4. Por apellidos …");
            System.out.println("--------------------");
            System.out.println("0. Volver al menú principal");

            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> grupos();
                case 2 -> edad();
                case 3 -> nia();
                case 4 -> apellidos();
            }
        } while (seleccion != 0);
    }
    public static void pruebas() {
        System.out.println("Cuantos alumnos?");
        int cantidad = Integer.parseInt(leer.nextLine());
        String nia;
        String nombre;
        String apellidos;
        String nacimiento;
        String grupo;
        int telefono;
        Random aleatorio = new Random();
        for (int i = 0; i < cantidad; i++) {
            nia = "Y" + aleatorio.nextInt(100000000, 999999999);
            nombre = aleatorio.nextBoolean() ? "Jose" : "Maria";
            apellidos = aleatorio.nextBoolean() ? "Gomez" : "Perez";
            nacimiento = "01-01-2000";
            grupo = aleatorio.nextBoolean() ? "DAM" : "DAW";
            telefono = aleatorio.nextInt(100000000, 999999999);

            for (int j = 0; j < alumnos.length; j++) {
                if (alumnos[j] == null) {
                    alumnos[j] = new Alumnos(nia, nombre, apellidos, nacimiento, grupo, telefono);
                    System.out.println(alumnos[j].toString());
                    break;
                }
            }
        }
    }

    public static void grupos() {
        System.out.println("Que grupo?");
        String clase = leer.nextLine();
        for (Alumnos alumno : alumnos) {
            if (alumno != null && clase.equals(alumno.getGrupo())) {
                System.out.println(alumno);
            }
        }
    }

    public static void edad() {
        System.out.println("¿Qué edad?");
        int edadBusqueda = Integer.parseInt(leer.nextLine());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (Alumnos alumno : alumnos) {
            if (alumno != null) {
                String fechaNacimiento = alumno.getNacimiento();
                LocalDate birthDate = LocalDate.parse(fechaNacimiento, formatter);
                LocalDate currentDate = LocalDate.now();
                int edad = Period.between(birthDate, currentDate).getYears();
                if (edad == edadBusqueda) {
                    System.out.println(alumno);
                }
            }
        }
    }

    public static void nia() {
        System.out.println("¿Qué NIA?");
        String niaBusqueda = leer.nextLine();

        for (Alumnos alumno : alumnos) {
            if (alumno != null && niaBusqueda.equals(alumno.getNia())) {
                System.out.println(alumno);
                return;
            }
        }
        System.out.println("NIA no encontrado.");
    }

    public static void apellidos() {
        System.out.println("¿Qué apellidos?");
        String apellidosBusqueda = leer.nextLine();

        for (Alumnos alumno : alumnos) {
            if (alumno != null && apellidosBusqueda.equals(alumno.getApellidos())) {
                System.out.println(alumno);
            }
        }
    }
}
