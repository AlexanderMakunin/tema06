package com.alexandermakunin.tema06pilascolas.hospital;

import java.util.Arrays;

public class Hospital {
    private final int CANT_COLAS = 5;
    private ColaConsulta[] cola;

    public Hospital() {
        this.cola = new ColaConsulta[CANT_COLAS];
    }

    public Hospital(int numConsulta) {
        this.cola = new ColaConsulta[numConsulta];
    }

    public ColaConsulta[] getCola() {
        return cola;
    }

    public void setCola(ColaConsulta[] cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "cola=" + Arrays.toString(cola) +
                '}';
    }
}
