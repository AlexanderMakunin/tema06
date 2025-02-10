package com.alexandermakunin.tema06pilascolas.hospital;

import java.util.Arrays;

public class Hospital {
    private final int CANT_COLAS = 5;
    private ColaConsulta[] cola = new ColaConsulta[CANT_COLAS];

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
