package com.alexandermakunin.ejercicio2;

public class Principal {
    public static void main(String[] args) {
        Asignatura porDefecto = new Asignatura();
        System.out.println(porDefecto);
        Asignatura asignatura = new Asignatura("Entornos",1020,2);
        System.out.println(asignatura);
    }
}
