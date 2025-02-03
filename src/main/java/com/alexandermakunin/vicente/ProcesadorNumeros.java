package com.alexandermakunin.vicente;

public class ProcesadorNumeros {
    // El main para hacer las pruebas
    public static void main(String[] args) {
        // Inicializar valores
        int num = 11;
        int cero = 0;
        int num2 = 12;
        int numNegativo = -1;
        int[] arr = {1,2,3,4,5};
        int[] arrNull = null;
        // Para esPrimo
        System.out.println(esPrimo(num)); // True
        System.out.println(esPrimo(cero)); // False
        System.out.println(esPrimo(num2)); // False
        // Para factorial
        //System.out.println(factorial(numNegativo)); // Throw Exception
        System.out.println(factorial(num)); // Valor esperado: 39916800
        // Para contarPares
        System.out.println(contarPares(arr)); // Valor esperado: 2
        //System.out.println(contarPares(arrNull)); // Throw Exception
        // Para encontrarMaximo
        System.out.println(encontrarMaximo(arr)); // Valor esperado: 5
        //System.out.println(encontrarMaximo(arrNull)); // Throw Exception
        // Para esPalindromo
        System.out.println(esPalindromo(num)); // True
        System.out.println(esPalindromo(numNegativo)); // False
    }

    // Método para verificar si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) return false; // Si es menor 2 devuelva false
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // Si no es primo devuelva false
        }
        return true; // En otro cualquier cosa devuelva true
    }

    // Método para calcular el factorial de un número
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser no negativo"); // Si es menor a 0 tire una excepcion
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado; // En otro cualquier caso devuelva el resultado
    }

    // Método para contar números pares en un array
    public static int contarPares(int[] numeros) {
        if (numeros == null) throw new IllegalArgumentException("El array no puede ser nulo"); // Si es nulo tire una excepcion
        int contador = 0;
        for (int num : numeros) {
            if (num % 2 == 0) contador++;
        }
        return contador + 1; // ERROR: se suma un 1 extra incorrectamente
                            // En otro cualquier caso devuelva cuantos pares hay
    }

    // Método para encontrar el número más grande en un array
    public static int encontrarMaximo(int[] numeros) {
        if (numeros == null || numeros.length == 0) throw new IllegalArgumentException("El array no puede estar vacío"); // Si es nulo o igual a 0 tire una excepcion
        int maximo = 0; // ERROR: debe inicializarse con numeros[0], no con 0
        for (int num : numeros) {
            if (num > maximo) maximo = num;
        }
        return maximo; // Que devuelva el numero maximo
    }

    // Método para verificar si un número es un palíndromo
    public static boolean esPalindromo(int n) {
        if (n < 0) return false; // No consideramos negativos como palíndromos y devuelve false
        int original = n, inverso = 0;
        while (n > 0) {
            int digito = n % 10;
            inverso = inverso * 10 + digito;
            n /= 10;
        }
        return original == inverso; // Devuelve true
    }
}