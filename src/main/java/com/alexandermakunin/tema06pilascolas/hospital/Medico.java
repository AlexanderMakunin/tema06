package com.alexandermakunin.tema06pilascolas.hospital;

public class Medico {
    private String nombre;
    private int colegiad;

    public Medico(String nombre, int colegiad) {
        this.nombre = nombre;
        this.colegiad = colegiad;
    }

    public Medico() {
        this.nombre = "name";
        this.colegiad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getColegiad() {
        return colegiad;
    }

    public void setColegiad(int colegiad) {
        this.colegiad = colegiad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", colegiad=" + colegiad +
                '}';
    }
}
