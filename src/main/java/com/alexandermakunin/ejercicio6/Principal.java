package com.alexandermakunin.ejercicio6;

import com.alexandermakunin.ejercicio3.Alumnos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static final int MAX_BICICLETAS = 100;
    public static Bicicleta[] bicicletas = new Bicicleta[MAX_BICICLETAS];
    public static void main(String[] args) {
        int seleccion;
        do {
            System.out.println("*************************");
            System.out.println("** GESTIÓN DE BICICLETAS **");
            System.out.println("*************************");
            System.out.println("1.- Añadir bicicleta …");
            System.out.println("2.- Vender bicicleta ...");
            System.out.println("3.- Consultar bicicleta …");
            System.out.println("4.- Mostrar stock");
            System.out.println("5.- Pruebas");
            System.out.println("------------------------------------");
            System.out.println("0.- Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevaBicicleta();
                case 2 -> venderBicicleta();
                case 3 -> consultas();
                case 4 -> mostrarStock();
                case 5 -> pruebas();
            }
        } while (seleccion != 0);
    }
    public static void nuevaBicicleta() {
        System.out.println("Indique el identificador");
        String referencia = leer.nextLine();
        for (int i = 0; i < bicicletas.length-1; i++) {
            if (bicicletas[i] != null && bicicletas[i].getReferencia().equals(referencia)) {
                System.out.println("La bicicleta ya existe");
                bicicletas[i].setExistencias(+1);
                return;
            }
        }
        System.out.println("Indique la marca");
        String marca = leer.nextLine();
        System.out.println("Indique el modelo");
        String modelo = leer.nextLine();
        System.out.println("El peso (unicamente numeros)");
        int kg = Integer.parseInt(leer.nextLine());
        System.out.println("El tamaño de las ruedas");
        int tamanyo = Integer.parseInt(leer.nextLine());
        System.out.println("Tiene motor? (S/N)");
        char tiene = leer.nextLine().charAt(0);
        boolean motor;
        if (tiene == 'S'){
            motor = true;
        } else {
            motor = false;
        }
        System.out.println("Indique la fecha de fabricación usando este estandar XX-XX-XXXX");
        String fabricacion = leer.nextLine();
        System.out.println("Indique el precio");
        int precio = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < bicicletas.length-1; i++) {
            if (bicicletas[i] == null) {
                bicicletas[i] = new Bicicleta(referencia, marca, modelo, kg, tamanyo, motor,fabricacion,precio);
                System.out.println("Alumno registrado exitosamente.");
                return;
            }
        }
        System.out.println("No hay espacio disponible para más alumnos.");
    }
    public static void venderBicicleta() {
        System.out.println("Indique la referencia");
        String referencia = leer.nextLine();
        for (int i = 0; i < bicicletas.length-1; i++) {
            if (bicicletas[i] != null && bicicletas[i].getReferencia().equals(referencia)) {
                if (bicicletas[i].getExistencias() >= 1){
                    System.out.println("bicicleta " + referencia + "vendida correctamente");
                    bicicletas[i].setExistencias(-1);
                    break;
                } else {
                    System.out.println("No quedan existencias");
                }
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
    public static void mostrarStock(){

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
