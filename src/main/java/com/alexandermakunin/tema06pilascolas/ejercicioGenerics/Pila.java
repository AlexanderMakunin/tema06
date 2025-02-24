package com.alexandermakunin.tema06pilascolas.ejercicioGenerics;

import java.util.Arrays;
import java.util.Objects;

/**
 * JavaDoc no gracias
 **/
public class Pila<T> {
    /** Tamaño inicial por defecto */
    private static final int INITIAL_SIZE = 10;
    /** Factor de crecimiento cada vez que el array requiera ser redimensionado */
    private static final float GROW_FACTOR = 2f;
    /** Valor con el que reconocemos una condición de error */
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    /** Array donde se van a guardar los valores de la pila */
    private T[] data;
    /** Tamaño actual de la pila */
    private int size;

    /**
     * Crea una pila con el tamaño inicial por defecto INITIAL_SIZE
     */
    public Pila() {
        this(INITIAL_SIZE);
    }

    /**
     * Crea una pila de tamaño inicial recibido como parámetro
     * @param size Capacidad inicial de la pila
     */
    @SuppressWarnings("unchecked")
    public Pila(int size) {
        this.data = (T[]) new Object[size];
        this.size = 0;
    }

    public void clear() {
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public Pila<T> clone() {
        Pila<T> copy = new Pila<>(size);
        for (int i = 0; i < size; i++) {
            copy.push(data[i]);
        }
        return copy;
    }

    @SuppressWarnings("unchecked")
    public T[] peek(int n) {
        if (n > size) n = size;
        T[] peek = Arrays.copyOfRange(data, size - n, size);
        return peek;
    }


    public int search(T element) {
        for (int i = size - 1, distancia = 1; i >= 0; i--, distancia++) {
            if (Objects.equals(data[i], element)) {
                return distancia;
            }
        }
        return -1;
    }


    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;
        }
    }


    /**
     * Añade un elemento a la cima de la pila
     * @param e Elemento a añadir
     */
    public void push(T e) {
        if (isFull()) {
            expand();
        }
        data[size] = e;
        size++;
    }

    /**
     * Expande el tamaño de la pila con el factor de crecimiento indicado por GROW_FACTOR
     */
    private void expand() {
        data = Arrays.copyOf(data, Math.round(data.length * GROW_FACTOR));
    }

    /**
     * Extrae el elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila está vacía
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T e = data[0];
        size--;
        moveToLeft();
        return e;
    }

    public void moveToLeft() {
        for (int i = 0; i < data.length-1; i++) {
            data[i] = data[i+1];
        }
    }

    /**
     * Obtiene el valor (sin extraer) del elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila está vacía
     */
    public T top() {
        if (isEmpty()) {
            return null; // En lugar de Double.NEGATIVE_INFINITY
        }
        T e = data[size - 1];
        return e;
    }

    /**
     * Determina si la pila está llena
     * Método de uso interno y por tanto privado ya que desde el punto de vista del
     * programador que utilice esta clase no tiene sentido, ya que la pila es dinámica,
     * es decir, crece automáticamente.
     * @return true si el array ha alcanzado su capacidad máxima o false en caso contrario
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Determina si la pila está vacía
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos que hay en la pila
     * @return Número de elementos de la pila
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
