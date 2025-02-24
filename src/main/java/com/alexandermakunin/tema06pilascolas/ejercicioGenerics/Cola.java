package com.alexandermakunin.tema06pilascolas.ejercicioGenerics;

import java.util.Arrays;
import java.util.Objects;

/**
 * Cola de consultas genérica
 **/
public class Cola<T> {
    /**
     * Tamaño inicial por defecto
     */
    private static final int INITIAL_SIZE = 10;
    /**
     * Factor de crecimiento cada vez que el array requiera ser redimensionado
     */
    private static final float GROW_FACTOR = 2f;
    /**
     * Array donde se guardan los valores de la cola
     */
    private T[] data;
    /**
     * Tamaño actual de la cola
     */
    private int size;

    /**
     * Crea una cola con el tamaño inicial por defecto INITIAL_SIZE
     */
    @SuppressWarnings("unchecked")
    public Cola() {
        this.data = (T[]) new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public void clear() {
        size = 0;
    }


    public Cola<T> clone() {
        Cola<T> copy = new Cola<>(size);
        for (int i = 0; i < size; i++) {
            copy.push(data[i]);
        }
        return copy;
    }


    public T peekLast() {
        return isEmpty() ? null : data[size - 1];
    }


    public int search(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], element)) {
                return i + 1;
            }
        }
        return -1;
    }


    public void reverse() {
        Cola<T> copy = clone();
        clear();
        for (int i = copy.size - 1; i >= 0; i--) {
            push(copy.data[i]);
        }
    }



    /**
     * Crea una cola de tamaño inicial recibido como parámetro
     *
     * @param size Capacidad inicial de la cola
     */
    @SuppressWarnings("unchecked")
    public Cola(int size) {
        this.data = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * Añade un elemento al final de la cola
     *
     * @param value Elemento a añadir
     */
    public void push(T value) {
        if (isFull()) {
            expand();
        }
        data[size] = value;
        size++;
    }

    /**
     * Expande el tamaño de la cola con el factor de crecimiento indicado por GROW_FACTOR
     */
    private void expand() {
        data = Arrays.copyOf(data, Math.round(data.length * GROW_FACTOR));
    }

    /**
     * Extrae el primer elemento de la cola
     *
     * @return El primer elemento de la cola o null si está vacía
     */
    public T pop() {
        if (isEmpty()) {
            return null; // En lugar de Double.NEGATIVE_INFINITY
        }
        T e = data[0];
        size--;
        moveToLeft();
        return e;
    }

    /**
     * Mueve los elementos de la cola a la izquierda después de un pop()
     */
    public void moveToLeft() {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    /**
     * Obtiene el primer valor sin extraerlo
     *
     * @return El primer elemento o null si la cola está vacía
     */
    public T peek() {
        return isEmpty() ? null : data[0];
    }

    /**
     * Determina si la cola está llena
     *
     * @return true si la cola ha alcanzado su capacidad máxima, false en caso contrario
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Determina si la cola está vacía
     *
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos en la cola
     *
     * @return Número de elementos en la cola
     */
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cola<?> that = (Cola<?>) o;
        return size == that.size && Objects.deepEquals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(data), size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
