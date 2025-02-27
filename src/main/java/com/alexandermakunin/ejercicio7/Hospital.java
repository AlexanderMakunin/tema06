package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Hospital {
    final int CANT_PACIENTES = 40;
    Pacientes[] pacientes = new Pacientes[CANT_PACIENTES];


    public boolean nuevoPaciente(int SIP) {
        for (Pacientes paciente : pacientes) {
            if (paciente != null && paciente.getSIP() == SIP) {
                return true;
            }
        }
        return false;
    }

    public boolean nuevoPaciente(int SIP, String NOMBRE, Pacientes.sexo SEX, int EDAD, String SINTOMATOLOGIA) {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] == null) {
                pacientes[i] = new Pacientes(SIP, NOMBRE, SEX, EDAD, SINTOMATOLOGIA);
                return true;
            }
        }
        return false;
    }

    public Pacientes buscarPaciente(int SIP) {
        for (Pacientes paciente : pacientes) {
            if (paciente.getSIP() == SIP) {
                return paciente;
            }
        }
        return null;
    }

    public Pacientes[] buscarPaciente(LocalDateTime fechaInicioTime, LocalDateTime fechaFinTime) {
        int count = 0;

        for (Pacientes paciente : pacientes) {
            long diferencia;

            if (paciente.isAtendido()) {
                if (fechaFinTime == null) {
                    diferencia = ChronoUnit.SECONDS.between(fechaInicioTime, paciente.getLLEGADA());
                } else {
                    diferencia = ChronoUnit.SECONDS.between(paciente.getLLEGADA(), fechaFinTime);
                }

                // Si el paciente fue atendido en el rango de fechas, aumentar el contador
                if (diferencia >= 0) {
                    count++;
                }
            }
        }

        Pacientes[] pacientesHora = new Pacientes[count];
        int index = 0;

        for (int i = 0; i < pacientes.length; i++) {
            long diferencia;

            if (pacientes[i].isAtendido()) {
                if (fechaFinTime == null) {
                    diferencia = ChronoUnit.SECONDS.between(fechaInicioTime, pacientes[i].getLLEGADA());
                } else {
                    diferencia = ChronoUnit.SECONDS.between(pacientes[i].getLLEGADA(), fechaFinTime);
                }
                if (diferencia >= 0) {
                    pacientesHora[index++] = pacientes[i];
                }
            }
        }

        return pacientesHora;
    }



    public boolean atenderPaciente(Pacientes paciente, float temp, int ppm, int tenSis, int tenDias) {
        if (paciente != null) {
            paciente.vitales(temp,ppm,tenSis,tenDias);
            paciente.setAtendido(true);
            return true;
        } else {
            return false;
        }
    }

    public int[] estadisticas() {
        float totalTemp = 0;
        int totalPpm = 0;
        int totalTenArt = 0;
        int totalEdad = 0;
        int totalHombres = 0;
        int totalMujeres = 0;
        int totalPacientes = 0;
        for (Pacientes paciente : pacientes) {
            totalPacientes += 1;
            totalTemp += paciente.getPreRev()[0];
            totalPpm += (int) paciente.getPreRev()[1];
            totalTenArt += (int) paciente.getPreRev()[2];
            totalEdad += paciente.getEDAD();
            if (paciente.getSEX() == Pacientes.sexo.M) {
                totalHombres += 1;
            } else {
                totalMujeres += 1;
            }
        }
        int mediaTemp = (int) (totalTemp / totalPacientes);
        int mediaPpm = (totalPpm / totalPacientes);
        int mediaTenArt = (totalTenArt / totalPacientes);
        int mediaEdad = (totalEdad / totalPacientes);
        float porcentajeHombres = (totalHombres * 100.0f) / totalPacientes;
        float porcentajeMujeres = (totalMujeres * 100.0f) / totalPacientes;
        // esto es para redondear
        int mediaHombres = (int) porcentajeHombres;
        int mediaMujeres = (int) porcentajeMujeres;

        return new int[]{mediaTemp, mediaPpm, mediaTenArt, mediaEdad, mediaHombres, mediaMujeres};
    }

    public Pacientes[] pacientesAtendidos() {
        int count = 0;
        for (Pacientes paciente : pacientes) {
            if (paciente.isAtendido()) {
                count += 1;
            }
        }
        Pacientes[] pacientesAtendidos = new Pacientes[count];
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i].isAtendido()) {
                pacientesAtendidos[i] = pacientes[i];
            }
        }
        return pacientesAtendidos;
    }

    public boolean verificarAlta(Pacientes paciente) {
        return paciente.getHORA_ALTA_MEDICA() == null;
    }

    public boolean darAlta(Pacientes paciente, String motivo) {
        paciente.setMotivo(motivo);
        return paciente.isAlta_medica();
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "pacientes=" + Arrays.toString(pacientes) +
                '}';
    }
}
