package com.alexandermakunin.vicente;

import java.util.Scanner;
import java.util.EmptyStackException;

public class Pila {
    
    // Clase interna para representar cada nodo de la pila
    private class Nodo {
        int dato;
        Nodo siguiente;
        
        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    private Nodo cima; // Referencia al nodo que está en la cima de la pila

    // Constructor de la pila (inicialmente vacía)
    public Pila() {
        cima = null;
    }
    
    // Método para apilar un número
    public void push(int numero) {
        if (!isEmpty()) {
            int dato1;
            dato1 = pop();
            if (!isEmpty()) {
                int dato2 = pop();
                if ((dato2 - dato1) * 2 <= numero) {
                    Nodo nuevo = new Nodo(dato2);
                    nuevo.siguiente = cima;
                    cima = nuevo;
                    Nodo nuevo2 = new Nodo(dato1);
                    nuevo.siguiente = cima;
                    cima = nuevo2;
                    Nodo nuevo3 = new Nodo(numero);
                    nuevo.siguiente = cima;
                    cima = nuevo3;
                } else {
                    Nodo nuevo = new Nodo(dato2);
                    nuevo.siguiente = cima;
                    cima = nuevo;
                    Nodo nuevo2 = new Nodo(dato1);
                    nuevo.siguiente = cima;
                    cima = nuevo2;
                }
            } else {
                if (dato1 * 2 <= numero) {
                    Nodo nuevo = new Nodo(dato1);
                    nuevo.siguiente = cima;
                    cima = nuevo;
                    Nodo nuevo2 = new Nodo(numero);
                    nuevo.siguiente = cima;
                    cima = nuevo2;
                } else {
                    Nodo nuevo = new Nodo(dato1);
                    nuevo.siguiente = cima;
                    cima = nuevo;
                }
            }
        } else {
            Nodo nuevo = new Nodo(numero);
            nuevo.siguiente = cima;
            cima = nuevo;
        }
    }
    
    // Método para desapilar (quita y retorna el elemento de la cima)
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }
    
    // Método para obtener el elemento en la cima sin quitarlo
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return cima.dato;
    }
    
    // Método que indica si la pila está vacía
    public boolean isEmpty() {
        return cima == null;
    }
    
    // Método main con menú interactivo utilizando solo operaciones de la pila
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila pila = new Pila();
        int opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Apilar un número");
            System.out.println("2. Desapilar");
            System.out.println("3. Mostrar la pila completa");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    System.out.print("Ingrese un número a apilar: ");
                    int numero = scanner.nextInt();
                    pila.push(numero);
                    System.out.println("Número apilado.");
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        int desapilado = pila.pop();
                        System.out.println("Se desapiló: " + desapilado);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
                case 3:
                    if (pila.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("Contenido de la pila (de cima a base):");
                        // Se utiliza una pila auxiliar para mostrar los elementos
                        Pila auxiliar = new Pila();
                        // Se desapilan todos los elementos para mostrarlos
                        while (!pila.isEmpty()) {
                            int dato = pila.pop();
                            System.out.println(dato);
                            auxiliar.push(dato);
                        }
                        // Se restaura la pila original re-apilando los elementos
                        while (!auxiliar.isEmpty()) {
                            pila.push(auxiliar.pop());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while(opcion != 4);

        scanner.close();
    }
}
