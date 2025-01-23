package com.alexandermakunin.ejercicio1;

public class Coche {
    public enum TipoCoche {
        MINI, UTILITARIO, FAMILIAR, DEPORTIVO
    }
    public enum ModalidadSeguro {
        TERCEROS,RIESGO
    }
    private String modelo;
    private String color;
    private boolean metalizado;
    private String matriculado;
    private TipoCoche tipo;
    private int anyo;
    private ModalidadSeguro seguro;
    // Constructor
    public Coche(String modelo, String color, boolean metalizado, String matriculado, TipoCoche tipo, int anyo, ModalidadSeguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizado = metalizado;
        this.matriculado = matriculado;
        this.tipo = tipo;
        this.anyo = anyo;
        this.seguro = seguro;
    }
    // Constructor

    public Coche() {
        this("Cochecito", "rosita", false, "UwU", TipoCoche.MINI, 1969, ModalidadSeguro.TERCEROS);
    }


    // Resto de métodos

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", metalizado=" + metalizado +
                ", matriculado='" + matriculado + '\'' +
                ", tipo=" + tipo +
                ", anyo=" + anyo +
                ", seguro=" + seguro +
                '}';
    }
}
