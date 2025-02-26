package com.alexandermakunin.ejercicio7;

import com.alexandermakunin.ejercicio3.Alumnos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

    public boolean nuevoPaciente2(int SIP, String NOMBRE, Pacientes.sexo SEX, int EDAD, String SINTOMATOLOGIA) {
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
}
