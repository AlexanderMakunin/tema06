package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AtencionPaciente {
    private Pacientes pacientes;
    private LocalDateTime HORA_ALTA_MEDICA;
    private boolean alta_medica = false;
    private boolean atendido = false;
    private String motivo;
    private static float[] preRev;

    public AtencionPaciente(Pacientes pacientes, float[] preRev) {
        this.pacientes = pacientes;
        this.HORA_ALTA_MEDICA = LocalDateTime.now();
        this.motivo = motivo;
        preRev = preRev;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public float[] getPreRev() {
        return preRev;
    }

    public LocalDateTime getHORA_ALTA_MEDICA() {
        return HORA_ALTA_MEDICA;
    }

    public void setHORA_ALTA_MEDICA(LocalDateTime HORA_ALTA_MEDICA) {
        this.HORA_ALTA_MEDICA = HORA_ALTA_MEDICA;
    }

    public boolean isAlta_medica() {
        return alta_medica;
    }

    public void setAlta_medica(boolean alta_medica) {
        this.alta_medica = alta_medica;
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

    public static float[] vitales(float temp, int ppm, int tenSis, int tenDias) {
        preRev[0] = temp;
        preRev[1] = ppm;
        preRev[2] = tenSis;
        preRev[3] = tenDias;
        return preRev;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        if (preRev[0] != 0) {
            sb.append(", preRev=" + Arrays.toString(preRev));
        }
        if (HORA_ALTA_MEDICA != null) {
            String formattedHora_Alta = HORA_ALTA_MEDICA.format(formatter);
            sb.append(", HORA_ALTA_MEDICA=" + formattedHora_Alta);
        }
        if (motivo != null) {
            sb.append(", motivo='" + motivo + '\'');
        }
        return sb + "";
    }
}
