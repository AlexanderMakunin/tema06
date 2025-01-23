package com.alexandermakunin.ejercicio3;

import java.util.Scanner;

public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        int seleccion;

        do {
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno …");
            System.out.println("2. Baja de alumno …");
            System.out.println("3. Consultas …");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoAlumno();
            }
        } while (seleccion > 3 || seleccion < 0);
    }
    public static void nuevoAlumno() {
        String NIA = leer.nextLine();
        String nombre = leer.nextLine();
        String apellidos = leer.nextLine();
        String nacimiento = leer.nextLine();
        String grupo = leer.nextLine();
        int telefono = Integer.parseInt(leer.nextLine());
        Alumnos alumno = new Alumnos(NIA,nombre,apellidos,nacimiento,grupo,telefono);
    }
}
