package com.alexandermakunin.tema06pilascolas.hospital;

import java.time.LocalDateTime;

public class Paciente {
    private String nombre;
    private String SIP;
    private LocalDateTime ingreso;

    public Paciente(String nombre, String SIP, LocalDateTime ingreso) {
        this.nombre = nombre;
        this.SIP = SIP;
        this.ingreso = ingreso;
    }

    public Paciente() {
        this.nombre = "nombre";
        this.SIP = "SIP";
        this.ingreso = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSIP() {
        return SIP;
    }

    public void setSIP(String SIP) {
        this.SIP = SIP;
    }

    public LocalDateTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", SIP='" + SIP + '\'' +
                ", ingreso=" + ingreso +
                '}';
    }
}
