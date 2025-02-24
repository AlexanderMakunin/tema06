package com.alexandermakunin.tema06pilascolas.hospital;

import java.time.LocalDateTime;
import java.util.Random;

public class Test {
    private final static Random aleatorio = new Random();
    public Paciente crearPaciente() {
        String[] nombres = {"Carlos", "María", "Juan", "Ana", "Pedro", "Lucía", "Diego", "Laura", "Luis", "Elena"};
        String nombre = nombres[aleatorio.nextInt(0, nombres.length)];
        String sip = aleatorio.nextInt(10000000,999999999) + (char) aleatorio.nextInt(65,91) + "";
        LocalDateTime localDateTime = LocalDateTime.now();
        return new Paciente(nombre,sip,localDateTime);
    }

    public Medico crearMedic() {
        String[] nombres = {"Carlos", "María", "Juan", "Ana", "Pedro", "Lucía", "Diego", "Laura", "Luis", "Elena"};
        String nombre = nombres[aleatorio.nextInt(0, nombres.length)];
        int colegiado = aleatorio.nextInt(100000,9999999);
        return new Medico(nombre,colegiado);
    }

    public Hospital crearHospital(int numConsultas, int numPacientes) {
        Hospital hospital = new Hospital(numConsultas);


        for (int i = 0; i < numConsultas; i++) {
            hospital.getCola()[i] = new ColaConsulta(crearMedic());
            for (int j = 0; j < numPacientes; j++) {
                hospital.getCola()[i].getPacienteCola().push(crearPaciente());
            }
        }
        return hospital;
    }
}
