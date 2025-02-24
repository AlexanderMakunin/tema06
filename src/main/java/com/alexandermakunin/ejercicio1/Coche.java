package com.alexandermakunin.ejercicio1;

import java.time.LocalDateTime;

public class Coche {
    public enum TipoCoche {
        MINI, UTILITARIO, FAMILIAR, DEPORTIVO
    }
    public enum ModalidadSeguro {
        TERCEROS,RIESGO
    }
    private final String modelo;
    private final String color;
    private final boolean metalizado;
    private final String matricula = crearMatricula();
    private final TipoCoche tipo;
    private final LocalDateTime anyo;
    private final ModalidadSeguro seguro;
    private static int count;
    // Constructor
    public Coche(String modelo, String color, boolean metalizado, TipoCoche tipo, LocalDateTime anyo, ModalidadSeguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizado = metalizado;
        this.tipo = tipo;
        this.anyo = anyo;
        this.seguro = seguro;
    }
    // Constructor

    public Coche() {
        this("Cochecito", "rosita", false, TipoCoche.MINI, LocalDateTime.now(), ModalidadSeguro.TERCEROS);
    }


    // Resto de métodos

    private String crearMatricula() {
        StringBuilder sb = new StringBuilder();
        String matricula;
        int contador = count;
        char c1 = 65;
        char c2 = 65;
        char c3 = 65;
        while (contador > 9999) {
            contador = contador - 9999;
            c3 += 1;
            if (c3 > 90) {
                c3 = 65;
                c2 += 1;
                if (c2 > 90) {
                    c2 = 65;
                    c1 += 1;
                }
            }
        }
        if (contador > 1000) {
            sb.append(contador);

        } else if (contador > 100) {
            sb.append("0").append(contador);
        } else if (contador > 10) {
            sb.append("00").append(contador);
        } else {
            sb.append("000").append(contador);
        }
        matricula = "" + sb + c1 + c2 + c3;
        count++;
        return matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", metalizado=" + metalizado +
                ", matricula='" + matricula + '\'' +
                ", tipo=" + tipo +
                ", anyo=" + anyo +
                ", seguro=" + seguro +
                '}';
    }
}
