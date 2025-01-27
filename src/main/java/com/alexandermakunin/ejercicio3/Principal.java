package com.alexandermakunin.ejercicio3;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static Alumnos alumno = new Alumnos();
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
        if (alumno.getNia().equals(NIA)) {
            System.out.println("Ese NIA ya esta en uso");
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
        Alumnos alumno = new Alumnos(NIA,nombre,apellidos,nacimiento,grupo,telefono);
    }
    public static void bajaAlumno() {
        System.out.println("Indique el NIA");
        String NIA = leer.nextLine();
        if (alumno.getNia().equals(NIA)) {
            alumno = null;
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
                //case 2 -> edad();
                //case 3 -> nia();
                //case 4 -> apellidos();
            }
        } while (seleccion != 0);
    }
    public static void pruebas() {
        System.out.println("Cuantos alumnos?");
        int cantidad = Integer.parseInt(leer.nextLine());
        String nia = " ";
        String nombre = " ";
        String apellidos = " ";
        String nacimiento = " ";
        String grupo = " ";
        int telefono = 0;
        for (int i = 0; i < cantidad; i++){
            Random aleatorio = new Random();
            int niaAleatorio = aleatorio.nextInt(1,4);
            switch (niaAleatorio) {
                case 1 -> nia = "Y123456789M";
                case 2 -> nia = "Y0987654321F";
                case 3 -> nia = "Y0000000000A";
            }
            int nombreAleatorio = aleatorio.nextInt(1,4);
            switch (nombreAleatorio) {
                case 1 -> nombre = "Jose";
                case 2 -> nombre = "Maria";
                case 3 -> nombre = "Alien";
            }
            int apellidosAleatorio = aleatorio.nextInt(1,4);
            switch (apellidosAleatorio) {
                case 1 -> apellidos = "Maria";
                case 2 -> apellidos = "Jose";
                case 3 -> apellidos = "Marciano";
            }
            int nacimientoAleatorio = aleatorio.nextInt(1,4);
            switch (nacimientoAleatorio) {
                case 1 -> nacimiento = "03-12-1985";
                case 2 -> nacimiento = "06-9-1995";
                case 3 -> nacimiento = "01-01-0001";
            }
            int grupoAleatorio = aleatorio.nextInt(1,4);
            switch (grupoAleatorio) {
                case 1 -> grupo = "DAM";
                case 2 -> grupo = "DAW";
                case 3 -> grupo = "Vida humana";
            }
            int telefonoAleatorio = aleatorio.nextInt(1,4);
            switch (telefonoAleatorio) {
                case 1 -> telefono = 834657843;
                case 2 -> telefono = 326547545;
                case 3 -> telefono = 999999999;
            }
            alumno = new Alumnos(nia,nombre,apellidos,nacimiento,grupo,telefono);
            System.out.println(alumno.toString());
        }
    }

    public static void grupos() {
        System.out.println("Que grupo?");
        String clase = leer.nextLine();
        for (int i = 0; i < 10;i++) {
            if (clase.equals(alumno.getGrupo())) {
                System.out.println(alumno.toString());
            }
        }
    }
}
