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
        motor = tiene == 'S';
        System.out.println("Indique la fecha de fabricación usando este estandar XX-XX-XXXX");
        String fabricacion = leer.nextLine();
        System.out.println("Indique el precio");
        int precio = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < bicicletas.length-1; i++) {
            if (bicicletas[i] == null) {
                bicicletas[i] = new Bicicleta(referencia, marca, modelo, kg, tamanyo, motor,fabricacion,precio);
                System.out.println("bicicleta registrado exitosamente.");
                return;
            }
        }
        System.out.println("No hay espacio disponible para más bicicletas.");
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
        System.out.println("¿Que bicicleta quiere revisar el id?");
        String stock = leer.nextLine();
        for (Bicicleta bicicleta : bicicletas){
            if (bicicleta.getReferencia().equals(stock)){
                System.out.println(bicicleta.getExistencias());
            }
        }

    }
    public static void pruebas() {
        System.out.println("Cuantos alumnos?");
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
            marca = aleatorio.nextBoolean() ? "Jose" : "Maria";
            modelo = aleatorio.nextBoolean() ? "Gomez" : "Perez";
            kg = aleatorio.nextInt(20, 50);
            tamanyo = aleatorio.nextInt(1,20);
            motor = aleatorio.nextBoolean();
            fabricacion = aleatorio.nextInt(0,31) + "-" + aleatorio.nextInt(0,13) + "-" + aleatorio.nextInt(1980,2025);
            precio = aleatorio.nextInt(0,1000000000);

            for (int j = 0; j < bicicletas.length; j++) {
                if (bicicletas[j] == null) {
                    if (bicicletas[j].equals(bicicletas[i].getReferencia())) {
                        bicicletas[i].setExistencias(+1);
                        break;
                    } else {
                        bicicletas[i] = new Bicicleta(referencia, marca, modelo, kg, tamanyo, motor, fabricacion, precio);
                        System.out.println(bicicletas[j].toString());
                        break;
                    }
                }
            }
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
                    return;
                }
            }
        }
        System.out.println("marca no encontrado.");
    }

    public static void modelo() {
        System.out.println("¿Qué NIA?");
        String modelo = leer.nextLine();

        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && modelo.equals(bicicleta.getModelo())) {
                System.out.println(bicicleta);
                return;
            }
        }
        System.out.println("modelo no encontrado.");
    }
}
