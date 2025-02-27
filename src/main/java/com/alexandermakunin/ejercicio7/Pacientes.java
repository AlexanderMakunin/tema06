package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pacientes {
    public enum sexo {
        M,V
    }
    private final int SIP;
    private final String NOMBRE;
    private final sexo SEX;
    private final int EDAD;
    private final LocalDateTime LLEGADA = LocalDateTime.now();
    private final String SINTOMATOLOGIA;

    public Pacientes(int SIP, String NOMBRE, sexo SEX, int EDAD, String SINTOMATOLOGIA) {
        this.SIP = SIP;
        this.NOMBRE = NOMBRE;
        this.SEX = SEX;
        this.EDAD = EDAD;
        this.SINTOMATOLOGIA = SINTOMATOLOGIA;
    }

    public int getSIP() {
        return SIP;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public sexo getSEX() {
        return SEX;
    }

    public int getEDAD() {
        return EDAD;
    }

    public LocalDateTime getLLEGADA() {
        return LLEGADA;
    }

    public String getSINTOMATOLOGIA() {
        return SINTOMATOLOGIA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacientes pacientes = (Pacientes) o;
        return SIP == pacientes.SIP;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(SIP);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedLlegada = LLEGADA.format(formatter);

        StringBuilder sb = new StringBuilder();

        sb.append("Pacientes{").append("SIP= " + SIP).append(", NOMBRE='" + NOMBRE + '\'').append(", SEX=" + SEX).append(", EDAD=" + EDAD).append(", LLEGADA=" + formattedLlegada).append(", SINTOMATOLOGIA='" + SINTOMATOLOGIA + '\'');

        sb.append('}');
        return sb.toString();
    }
}
