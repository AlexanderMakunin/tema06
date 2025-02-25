package com.alexandermakunin.ejercicio3;

public class Alumnos {
    private final int nia;
    private final String nombre;
    private final String apellidos;
    private final String nacimiento;
    private final String grupo;
    private final int telefono;

    public Alumnos(int nia, String nombre, String apellidos, String nacimiento, String grupo, int telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public Alumnos() {
        this (1234567890, "NOMBRE", "APELLIDOS", "XX-XX-XXXX", "GRUPO", 11234567);
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "nia='" + nia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", grupo='" + grupo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
