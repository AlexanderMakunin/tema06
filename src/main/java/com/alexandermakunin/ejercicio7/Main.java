package com.alexandermakunin.ejercicio7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Hospital hospital = new Hospital();
    public static Scanner leer = new Scanner(System.in);
    private static final boolean test = true;

    public static void main(String[] args) {
        if (test) {
            for (int i = 0; i < hospital.CANT_PACIENTES; i++) {
                Random rand = new Random();

                int sip = rand.nextInt(0,1000000000);
                String nombre = generarNombreFalso();
                String sexo = rand.nextBoolean() ? "M" : "V";
                Pacientes.sexo sex = Pacientes.sexo.valueOf(sexo);
                int edad = rand.nextInt(100) + 1;
                String sintomatologia = generarSintomasFalsos();
                if (!hospital.nuevoPaciente(sip)) {
                    hospital.nuevoPaciente(sip, nombre, sex, edad, sintomatologia);
                }
            }
        }
        System.out.println(hospital);
        menu();
    }

    private static String generarNombreFalso() {
        String[] nombres = {"Carlos", "Ana", "Sonia", "Juan", "Pedro", "María", "Lucía", "José"};
        String[] apellidos = {"Pérez", "González", "Mora", "Rodríguez", "Fernández", "Sánchez"};
        Random rand = new Random();
        return nombres[rand.nextInt(nombres.length)] + " " + apellidos[rand.nextInt(apellidos.length)];
    }

    private static String generarSintomasFalsos() {
        String[] sintomas = {
                "Dolor abdominal", "Mareo generalizado", "Dolor de cabeza", "Escalofríos",
                "Fiebre alta", "Tos seca", "Náuseas", "Dificultad para respirar"
        };
        Random rand = new Random();
        return sintomas[rand.nextInt(sintomas.length)];
    }

    public static void menu() {
        int seleccion;
        do {
            System.out.println("** URGENCIAS **");
            System.out.println("********************");
            System.out.println("1. Nuevo paciente …");
            System.out.println("2. Atender paciente …");
            System.out.println("3. Consultas …");
            System.out.println("4. Alta médica …");
            System.out.println("-----------------------------");
            System.out.println("0. Salir");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> nuevoPaciente();
                case 2 -> atenderPaciente();
                case 3 -> consultas();
                case 4 -> altaMedica();
            }
        } while (seleccion != 0);
    }

    public static void nuevoPaciente() {
        System.out.println("Indique el sip");
        int sip = Integer.parseInt(leer.nextLine());
        boolean check = hospital.nuevoPaciente(sip);
        if (check) {
            System.out.println("Ese paciente ya esta siendo atendido");
            return;
        }
        System.out.println("Indique el nombre");
        String nombre = leer.nextLine();
        System.out.println("Indique el genero (V o M)");
        String sexo = leer.nextLine();
        Pacientes.sexo sex = Pacientes.sexo.valueOf(sexo);
        System.out.println("Indique la edad");
        int edad = Integer.parseInt(leer.nextLine());
        System.out.println("Indique la sintologia");
        String sintomatologia = leer.nextLine();
        check = hospital.nuevoPaciente(sip, nombre, sex, edad, sintomatologia);
        if (check) {
            System.out.println("Paciente añadido exitosamente");
        } else {
            System.out.println("No se pudo realizarlo");
        }
    }

    public static void atenderPaciente() {
        System.out.println("Indique el SIP");
        int sip = Integer.parseInt(leer.nextLine());
        Pacientes paciente = hospital.buscarPaciente(sip);
        if (paciente != null) {
            if (hospital.verificarAlta(paciente)) {
                System.out.println(paciente);
                System.out.println("Indique su temperatura");
                float temp = Float.parseFloat(leer.nextLine());
                System.out.println("Indique su ppm");
                int ppm = Integer.parseInt(leer.nextLine());
                System.out.println("Indique su tenSis");
                int tenSis = Integer.parseInt(leer.nextLine());
                System.out.println("Indique su tenDias");
                int tenDias = Integer.parseInt(leer.nextLine());
                boolean check = hospital.atenderPaciente(paciente, temp, ppm, tenSis, tenDias);
                if (check) {
                    System.out.println("se ha atendido correctamente");
                } else {
                    System.out.println("no se pudo atender correctamente");
                }
            }
        }
    }

    public static void consultas() {
        int seleccion;
        do {
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("***************");
            System.out.println("1. Por Sip …");
            System.out.println("2. Por fechas …");
            System.out.println("3. Estadísticas");
            System.out.println("4. Mostrar histórico mensual");
            System.out.println("--------------------------------");
            System.out.println("0. Volver al menú principal");
            seleccion = Integer.parseInt(leer.nextLine());
            switch (seleccion) {
                case 1 -> consultaSIP();
                case 2 -> consultaFecha();
                case 3 -> consultaEstadisticas();
                case 4 -> consultaHistorial();
            }
        } while (seleccion != 0);
    }

    public static void consultaSIP() {
        System.out.println("Indique el SIP");
        int sip = Integer.parseInt(leer.nextLine());
        Pacientes paciente = hospital.buscarPaciente(sip);
        if (paciente != null) {
            System.out.println(paciente);
        } else {
            System.out.println("no se ha encontrado un paciente con ese SIP");
        }
    }

    public static void consultaFecha() {
        System.out.println("Indique la fecha inicial");
        String fechaInicio = leer.nextLine();
        System.out.println("Indique la fecha (pulse enter si no tiene)");
        String fechaFin = leer.nextLine();
        LocalDateTime fechaInicioTime;
        LocalDateTime fechaFinTime = null;
        if (fechaInicio.length() == 16) {
            fechaInicioTime = LocalDateTime.parse(fechaInicio, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        } else {
            fechaInicioTime = LocalDateTime.parse(fechaInicio + " 00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        }
        if (fechaFin.length() == 9 && fechaFin.charAt(2) == '-' && fechaFin.charAt(5) == '-') {
            fechaFinTime = LocalDateTime.parse(fechaFin + " 00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        }

        System.out.println(fechaInicioTime);

        Pacientes[] paciente = hospital.buscarPaciente(fechaInicioTime, fechaFinTime);
        for (Pacientes pacientes : paciente) {
            System.out.println(pacientes);
        }
    }

    public static void consultaEstadisticas() {
        int[] datos = hospital.estadisticas();
        for (int i = 0; i < datos.length; i++) {
            switch (i) {
                case 0 -> System.out.println("Media de temperatura: " + datos[i]);
                case 1 -> System.out.println("Media de pulsaciones por minuto: " + datos[i]);
                case 2 -> System.out.println("Media de los dos valores de la tensión arterial: " + datos[i]);
                case 3 -> System.out.println("Media de edad de los pacientes: " + datos[i]);
                case 4 -> System.out.println("Media de pacientes que son hombres: " + datos[i] + "%");
                case 5 -> System.out.println("Media de pacientes que son mujeres: " + datos[i] + "%");
            }
        }
    }

    public static void consultaHistorial() {
        Pacientes[] pacientes = hospital.pacientesAtendidos();
        for (Pacientes paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public static void altaMedica() {
        System.out.println("Indique el SIP");
        Pacientes paciente = hospital.buscarPaciente(Integer.parseInt(leer.nextLine()));
        System.out.println("Indique el motivo");
        String motivo = leer.nextLine();
        if (hospital.darAlta(paciente,motivo)) {
            System.out.println("Dado de alta exitosamente");
        } else {
            System.out.println("Ha habido un error");
        }
    }
}
