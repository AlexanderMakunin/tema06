package com.alexandermakunin.ejercicio2;

public class Asignatura {
    private final String nombre;
    private final int codigo;
    private final int curso;

    public Asignatura(String nombre, int codigo, int curso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
    }

    public Asignatura() {
        this ("Programación", 1017, 1);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", curso='" + curso + '\'' +
                '}';
    }
}
