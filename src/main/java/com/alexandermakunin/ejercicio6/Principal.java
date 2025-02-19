package com.alexandermakunin.ejercicio6;

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
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && bicicleta.getReferencia().equals(referencia)) {
                System.out.println("La bicicleta se ha añadido a las existencias");
                bicicleta.setExistencias(bicicleta.getExistencias()+1);
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
        motor = tiene == 'S' || tiene == 's';
        System.out.println("Indique la fecha de fabricación usando este estandar XX-XX-XXXX");
        String fabricacion = leer.nextLine();
        System.out.println("Indique el precio");
        int precio = Integer.parseInt(leer.nextLine());
        System.out.println("Cuantas de ellas quieres poner?");
        int stock = Integer.parseInt(leer.nextLine());
        if (stock <= 0) {
            stock = 1;
        }
        for (int i = 0; i < bicicletas.length; i++) {
            if (bicicletas[i] == null) {
                bicicletas[i] = new Bicicleta(referencia, marca, modelo, kg, tamanyo, motor,fabricacion,precio,stock);
                System.out.println("bicicleta registrado exitosamente.");
                return;
            }
        }
        System.out.println("No hay espacio disponible para más bicicletas.");
    }
    public static void venderBicicleta() {
        System.out.println("Indique la referencia");
        String referencia = leer.nextLine();
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && bicicleta.getReferencia().equals(referencia)) {
                if (bicicleta.getExistencias() >= 1) {
                    System.out.println("bicicleta " + referencia + "vendida correctamente");
                    bicicleta.setExistencias(bicicleta.getExistencias()-1);
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
            System.out.println("***********************");
            System.out.println("** CONSULTA BICICLETA **");
            System.out.println("*********************** ");
            System.out.println("1.- Consultar por referencia …");
            System.out.println("2.- Consultar por marca …");
            System.out.println("3.- Consultar por modelo …");
            System.out.println("---------------------------------");
            System.out.println("0.- Volver al menú principal");

            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> id();
                case 2 -> marca();
                case 3 -> modelo();
            }
        } while (seleccion != 0);
    }
    public static void mostrarStock(){
        System.out.println("¿Que bicicleta quiere mostrar el stock?");
        String stock = leer.nextLine();
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null) {
                if (bicicleta.getReferencia().equals(stock)) {
                    System.out.println(bicicleta.getExistencias());
                    return;
                }
            }
        }
        System.out.println("no se ha encontrado esa referencia");

    }
    public static void pruebas() {
        System.out.println("Cuantas bicicletas?");
        int cantidad = Integer.parseInt(leer.nextLine());
        String referencia;
        String marca;
        String modelo;
        int kg;
        int tamanyo;
        boolean motor;
        String fabricacion;
        int precio;
        Random aleatorio = new Random();
        for (int i = 0; i < cantidad; i++) {
            referencia = "Y" + aleatorio.nextInt(100000000, 999999999);
            marca = aleatorio.nextBoolean() ? "Bicicleta pro" : "Bicicleta mega";
            modelo = aleatorio.nextBoolean() ? "Competitivo" : "Normal";
            kg = aleatorio.nextInt(20, 50);
            tamanyo = aleatorio.nextInt(1,20);
            motor = aleatorio.nextBoolean();
            fabricacion = aleatorio.nextInt(0,31) + "-" + aleatorio.nextInt(0,13) + "-" + aleatorio.nextInt(1980,2025 + 1);
            precio = aleatorio.nextInt(0,1000000000);

            for (int j = 0; j < i + 1; j++) {
                if (bicicletas[i] != null) {
                    if (bicicletas[j].getReferencia().equals(referencia)) {
                        bicicletas[i].setExistencias(bicicletas[i].getExistencias()+1);
                    }
                } else if (bicicletas[j] == null) {
                    bicicletas[i] = new Bicicleta(referencia,marca,modelo,kg,tamanyo,motor,fabricacion,precio);
                }
            }
            System.out.println(bicicletas[i]);
        }
    }

    public static void id() {
        System.out.println("Que referencia?");
        String id = leer.nextLine();
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && id.equals(bicicleta.getReferencia())) {
                System.out.println(bicicleta);
                return;
            }
        }
        System.out.println("referencia no encontrado.");
    }

    public static void marca() {
        System.out.println("¿Qué marca?");
        String marca = leer.nextLine();

        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null) {
                if (bicicleta.getMarca().equals(marca)) {
                    System.out.println(bicicleta);
                }
            }
        }
        System.out.println("marca no encontrado.");
    }

    public static void modelo() {
        System.out.println("¿Qué modelo?");
        String modelo = leer.nextLine();

        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && modelo.equals(bicicleta.getModelo())) {
                System.out.println(bicicleta);
            }
        }
        System.out.println("modelo no encontrado.");
    }
}
