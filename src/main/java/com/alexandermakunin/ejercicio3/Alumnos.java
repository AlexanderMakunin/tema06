package com.alexandermakunin.ejercicio3;

public class Alumnos {
    private String nia;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String grupo;
    private int telefono;

    public Asignatura(String nia, String nombre, String apellidos, String nacimiento, String grupo, int telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public Asignatura() {
        this ("A1234567M", "NOMBRE", "APELLIDOS", "XX-XX-XXXX", "GRUPO", "+11234567");
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nia=" + nia + '\'' +
                ", nombre=" + nombre +
                ", apellidos=" + apellidos + '\'' +
           		"fecha nacimiento=" 
                '}';
    }
}
