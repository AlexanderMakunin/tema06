package com.alexandermakunin.tema06pilascolas.ejercicio1;

import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int tamanyoArray = 10;
        DynamicArray dynamicArray = new DynamicArray(tamanyoArray);
        for (int i = 0; i < tamanyoArray; i++) {
            dynamicArray.add(aleatorio.nextDouble() * 10);
        }
        System.out.println(dynamicArray);

        for (int i = 0; i < tamanyoArray; i++) {
            System.out.printf("dynamicArray[%d] = %.2f\n",i,dynamicArray.get(i));
        }
        double num = aleatorio.nextDouble() * 10;
        dynamicArray.add(aleatorio.nextInt(0,dynamicArray.size()),num);
        System.out.println(dynamicArray);

        dynamicArray.remove(aleatorio.nextInt(0, dynamicArray.size()));
        System.out.println(dynamicArray);

        System.out.println(dynamicArray.remove(num));
        System.out.println(dynamicArray);

        System.out.println(dynamicArray.get(aleatorio.nextInt(0, dynamicArray.size())));

        dynamicArray.set(aleatorio.nextInt(0, dynamicArray.size()), aleatorio.nextDouble());
        System.out.println(dynamicArray);
        System.out.println("El tamanyo es: "+dynamicArray.size());

    }
}
