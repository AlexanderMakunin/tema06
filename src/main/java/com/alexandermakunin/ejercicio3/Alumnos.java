package com.alexandermakunin.ejercicio3;

public class Alumnos {
    private String nia;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String grupo;
    private int telefono;

    public Alumnos(String nia, String nombre, String apellidos, String nacimiento, String grupo, int telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public Alumnos() {
        this ("A1234567M", "NOMBRE", "APELLIDOS", "XX-XX-XXXX", "GRUPO", 11234567);
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
