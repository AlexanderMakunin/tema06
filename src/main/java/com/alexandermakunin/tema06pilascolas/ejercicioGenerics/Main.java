package com.alexandermakunin.tema06pilascolas.ejercicioGenerics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE PILA ===");
        testPila();

        System.out.println("\n=== PRUEBAS DE COLA ===");
        testCola();

        System.out.println("\n=== PRUEBAS DE DYNAMIC ARRAY ===");
        testDynamicArray();
    }

    private static void testPila() {
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);

        System.out.println("Pila original: " + pila);
        System.out.println("Elemento en la cima (peek(3)): " + Arrays.toString(pila.peek(3)));
        System.out.println("Búsqueda del 30 (search): " + pila.search(30));

        pila.reverse();
        System.out.println("Pila después de reverse: " + pila);

        Pila<Integer> copiaPila = pila.clone();
        System.out.println("Copia de la pila: " + copiaPila.toString());

        pila.clear();
        System.out.println("Pila después de clear: " + pila);
    }

    private static void testCola() {
        Cola<String> cola = new Cola<>();
        cola.push("A");
        cola.push("B");
        cola.push("C");
        cola.push("D");
        cola.push("E");

        System.out.println("Cola original: " + cola);
        System.out.println("Último elemento (peekLast): " + cola.peekLast());
        System.out.println("Búsqueda de 'C' (search): " + cola.search("C"));

        cola.reverse();
        System.out.println("Cola después de reverse: " + cola);

        Cola<String> copiaCola = cola.clone();
        System.out.println("Copia de la cola: " + copiaCola);

        cola.clear();
        System.out.println("Cola después de clear: " + cola);
    }

    private static void testDynamicArray() {
        DynamicArray<Double> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1.1);
        dynamicArray.add(2.2);
        dynamicArray.add(3.3);
        dynamicArray.add(4.4);
        dynamicArray.add(5.5);

        System.out.println("DynamicArray original: " + dynamicArray);
        System.out.println("Índice de 3.3 (indexOf): " + dynamicArray.indexOf(3.3));

        dynamicArray.swap(1, 3);
        System.out.println("Después de swap(1,3): " + dynamicArray);

        dynamicArray.trimToSize();
        System.out.println("Después de trimToSize (capacidad ajustada)");

        DynamicArray<Double> copiaArray = dynamicArray.clone();
        System.out.println("Copia del DynamicArray: " + copiaArray);

        dynamicArray.clear();
        System.out.println("DynamicArray después de clear: " + dynamicArray);
    }
}

