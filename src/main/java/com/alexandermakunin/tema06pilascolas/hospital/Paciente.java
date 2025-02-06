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
}
