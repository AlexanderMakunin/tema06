package com.alexandermakunin.ejercicio3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static CentroEducativo centroEducativo = new CentroEducativo();


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
            if (seleccion >= 5 || seleccion < 0){
                System.out.println("Vuelve a intentarlo");
            } else {
                switch (seleccion) {
                    case 1 -> nuevoAlumno();
                    case 2 -> bajaAlumno();
                    case 3 -> consultas();
                    case 4 -> pruebas();
                }
            }
        } while (seleccion != 0);
    }

    public static void nuevoAlumno() {
        System.out.println("Indique el NIA");
        int NIA = Integer.parseInt(leer.nextLine());
        boolean check = centroEducativo.nuevoAlumno(NIA);
        if (check) {
            System.out.println("El NIA ya está registrado.");
            return;
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
        boolean check2 = centroEducativo.nuevoAlumno2(NIA, nombre,apellidos,nacimiento,grupo,telefono);
        if (check2) {
            System.out.println("Se ha registrado existosamente");
        } else {
            System.out.println("No hay espacio para mas alumnos");
        }
    }

    public static void bajaAlumno() {
        System.out.println("Indique el NIA");
        int NIA = Integer.parseInt(leer.nextLine());
        System.out.println(centroEducativo.bajaAlumno(NIA));
    }

    public static void pruebas() {
        System.out.println("Cuantos alumnos?");
        int cantidad = Integer.parseInt(leer.nextLine());
        centroEducativo.pruebas(cantidad);
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

    public static void grupos() {
        System.out.println("Que grupo?");
        String clase = leer.nextLine();
        System.out.println(Arrays.toString(centroEducativo.grupos(clase)));
    }

    public static void edad() {
        System.out.println("¿Qué edad?");
        int edadBusqueda = Integer.parseInt(leer.nextLine());
        System.out.println(Arrays.toString(centroEducativo.edad(edadBusqueda)));
    }

    public static void nia() {
        System.out.println("¿Qué NIA?");
        int niaBusqueda = Integer.parseInt(leer.nextLine());
        System.out.println(centroEducativo.nia(niaBusqueda));
    }

    public static void apellidos() {
        System.out.println("¿Qué apellidos?");
        String apellidosBusqueda = leer.nextLine();
        System.out.println(Arrays.toString(centroEducativo.apellidos(apellidosBusqueda)));
    }
}
