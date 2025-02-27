package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Hospital {
    final int CANT_PACIENTES = 40;
    Pacientes[] pacientes = new Pacientes[CANT_PACIENTES];
    AtencionPaciente[] atencionPacientes = new AtencionPaciente[CANT_PACIENTES * 30];

    public Pacientes buscarPaciente(int SIP) {
        for (Pacientes paciente : pacientes) {
            if (paciente != null && paciente.getSIP() == SIP) {
                return paciente;
            }
        }
        return null;
    }

    public AtencionPaciente buscarPaciente(Pacientes pacientes) {
        for (AtencionPaciente atencionPaciente : atencionPacientes) {
            if (atencionPaciente.getPacientes().getSIP() == pacientes.getSIP()) {
                return atencionPaciente;
            }
        }
        return null;
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

    public AtencionPaciente[] buscarPaciente(LocalDateTime fechaInicioTime, LocalDateTime fechaFinTime) {
        int count = 0;

        for (AtencionPaciente atencionPaciente : atencionPacientes) {
            if (atencionPaciente.isAtendido()) {
                if (fechaFinTime == null) {
                    if (atencionPaciente.getPacientes().getLLEGADA().isAfter(fechaInicioTime) && atencionPaciente.getPacientes().getLLEGADA().isBefore(LocalDateTime.now())) {
                        count++;
                    }
                } else {
                    if (atencionPaciente.getPacientes().getLLEGADA().isAfter(fechaInicioTime) && atencionPaciente.getPacientes().getLLEGADA().isBefore(fechaFinTime)) {
                        count++;
                    }
                }
            }
        }

        AtencionPaciente[] pacientesHora = new AtencionPaciente[count];
        int index = 0;

        for (int i = 0; i < atencionPacientes.length; i++) {
            if (atencionPacientes[i].isAtendido()) {
                if (fechaFinTime == null) {
                    if (pacientes[i].getLLEGADA().isAfter(fechaInicioTime) && pacientes[i].getLLEGADA().isBefore(LocalDateTime.now())) {
                        pacientesHora[index] = atencionPacientes[i];
                        index++;
                    }
                } else {
                    if (pacientes[i].getLLEGADA().isAfter(fechaInicioTime) && pacientes[i].getLLEGADA().isBefore(fechaFinTime)) {
                        pacientesHora[index] = atencionPacientes[i];
                        index++;
                    }
                }
            }
        }
        return pacientesHora;
    }

    public boolean atenderPaciente(Pacientes paciente, float temp, int ppm, int tenSis, int tenDias) {
        if (paciente != null) {
            for (int i = 0; i < atencionPacientes.length; i++) {
                if ( atencionPacientes[i] == null) {
                    AtencionPaciente atencionPaciente = new AtencionPaciente(paciente,AtencionPaciente.vitales(temp,ppm,tenSis,tenDias));
                    atencionPacientes[i] = atencionPaciente;
                }
            }
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
        for (AtencionPaciente atencionPaciente : atencionPacientes) {
            totalPacientes += 1;
            totalTemp += atencionPaciente.getPreRev()[0];
            totalPpm += (int) atencionPaciente.getPreRev()[1];
            totalTenArt += (int) atencionPaciente.getPreRev()[2];
            totalEdad += atencionPaciente.getPacientes().getEDAD();
            if (atencionPaciente.getPacientes().getSEX() == Pacientes.sexo.M) {
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

    public AtencionPaciente[] pacientesAtendidos() {
        return atencionPacientes;
    }

    public boolean darAlta(AtencionPaciente atencionPaciente, String motivo) {
        atencionPaciente.setMotivo(motivo);
        atencionPaciente.setAlta_medica(true);
        atencionPaciente.setAtendido(false);
        return atencionPaciente.isAlta_medica();
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "pacientes=" + Arrays.toString(pacientes) +
                '}';
    }
}
