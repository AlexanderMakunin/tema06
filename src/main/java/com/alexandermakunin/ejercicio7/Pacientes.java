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
    private LocalDateTime HORA_ALTA_MEDICA;
    private boolean alta_medica = false;
    private boolean atendido = false;
    private String motivo;
    private final int NUM_CONSTANTES_VITALES = 4;
    private final float[] preRev = new float[NUM_CONSTANTES_VITALES];

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

    public float[] getPreRev() {
        return preRev;
    }

    public LocalDateTime getHORA_ALTA_MEDICA() {
        return HORA_ALTA_MEDICA;
    }

    public boolean isAlta_medica() {
        return alta_medica;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean ATENDIDO) {
        this.atendido = ATENDIDO;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void vitales(float temp, int ppm, int tenSis, int tenDias) {
        this.preRev[0] = temp;
        this.preRev[1] = ppm;
        this.preRev[2] = tenSis;
        this.preRev[3] = tenDias;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedLlegada = LLEGADA.format(formatter);  // Formateamos la fecha para mostrarla sin la 'T'

        return "Pacientes{" +
                "SIP=" + SIP +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", SEX=" + SEX +
                ", EDAD=" + EDAD +
                ", LLEGADA=" + formattedLlegada +
                ", SINTOMATOLOGIA='" + SINTOMATOLOGIA + '\'' +
                ", HORA_ALTA_MEDICA=" + HORA_ALTA_MEDICA +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
