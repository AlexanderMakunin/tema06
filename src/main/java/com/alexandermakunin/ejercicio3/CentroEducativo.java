package com.alexandermakunin.ejercicio3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CentroEducativo {
    final int CANT_ALUMNOS = 100;
    Alumnos[] alumnos = new Alumnos[CANT_ALUMNOS];

    public boolean nuevoAlumno(int NIA) {
        for (Alumnos alumno : alumnos) {
            if (alumno != null && alumno.getNia() == NIA) {
                return true;
            }
        }
        return false;
    }

    public boolean nuevoAlumno2(int NIA, String nombre, String apellidos, String nacimiento, String grupo, int telefono) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumnos(NIA, nombre, apellidos, nacimiento, grupo, telefono);
                return true;
            }
        }
        return false;
    }

    public String bajaAlumno(int NIA) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == NIA) {
                alumnos[i] = null;
                return "Encontrado y eliminado exitosamente";
            }
        }
        return "No se ha encontrado el alumno con ese Nia";
    }

    public void pruebas(int cantidad) {
        int nia;
        String nombre;
        String apellidos;
        String nacimiento;
        String grupo;
        int telefono;
        Random aleatorio = new Random();

        for (int i = 0; i < cantidad; i++) {
            nia = aleatorio.nextInt(100000000, 999999999);
            nombre = aleatorio.nextBoolean() ? "Jose" : "Maria";
            apellidos = aleatorio.nextBoolean() ? "Gomez" : "Perez";
            nacimiento = "01-01-2000";
            grupo = aleatorio.nextBoolean() ? "DAM" : "DAW";
            telefono = aleatorio.nextInt(100000000, 999999999);

            for (int j = 0; j < alumnos.length; j++) {
                if (alumnos[j] == null) {
                    alumnos[j] = new Alumnos(nia, nombre, apellidos, nacimiento, grupo, telefono);
                    System.out.println(alumnos[j].toString());
                    break;
                }
            }
        }
    }

    public Alumnos[] grupos(String grupo) {
        int count = 0;

        for (Alumnos alumno : alumnos) {
            if (alumno != null && grupo.equals(alumno.getGrupo())) {
                count++;
            }
        }

        Alumnos[] alumnosGrupo = new Alumnos[count];
        for (int i = 0; i < alumnosGrupo.length; i++) {
            if (alumnos[i] != null && grupo.equals(alumnos[i].getGrupo())) {
                alumnosGrupo[i] = alumnos[i];
            }
        }
        return alumnosGrupo;
    }


    public Alumnos[] edad(int edadBusqueda) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int count = 0;

        for (Alumnos alumno : alumnos) {
            if (alumno != null) {
                String fechaNacimiento = alumno.getNacimiento();
                LocalDate birthDate = LocalDate.parse(fechaNacimiento, formatter);
                LocalDate currentDate = LocalDate.now();
                int edad = Period.between(birthDate, currentDate).getYears();
                if (edad == edadBusqueda) {
                    count++;
                }
            }
        }

        Alumnos[] alumnosEdad = new Alumnos[count];

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                String fechaNacimiento = alumnos[i].getNacimiento();
                LocalDate birthDate = LocalDate.parse(fechaNacimiento, formatter);
                LocalDate currentDate = LocalDate.now();
                int edad = Period.between(birthDate, currentDate).getYears();
                if (edad == edadBusqueda) {
                    alumnosEdad[i] = alumnos[i];
                }
            }
        }
        return alumnosEdad;
    }

    public String nia(int NIA) {
        for (Alumnos alumno : alumnos) {
            if (alumno != null && NIA == alumno.getNia()) {
                return alumno.toString();
            }
        }
        return "NIA no encontrado.";
    }

    public Alumnos[] apellidos(String apellidosBusqueda) {
        int count = 0;

        for (Alumnos alumno : alumnos) {
            if (alumno != null && apellidosBusqueda.equals(alumno.getApellidos())) {
                count++;
            }
        }
        Alumnos[] alumnosApellido = new Alumnos[count];
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && apellidosBusqueda.equals(alumnos[i].getApellidos())) {
                alumnosApellido[i] = alumnos[i];
            }
        }
        return alumnosApellido;
    }
}
