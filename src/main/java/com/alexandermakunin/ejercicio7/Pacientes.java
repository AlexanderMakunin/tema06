package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.util.Date;
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
        return "Pacientes{" +
                "SIP=" + SIP +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", SEX=" + SEX +
                ", EDAD=" + EDAD +
                ", LLEGADA=" + LLEGADA +
                ", SINTOMOLOGIA='" + SINTOMATOLOGIA + '\'' +
                '}';
    }
}
