package com.alexandermakunin.tema06pilascolas.hospital;

public class Hospital {
    private int CANT_COLAS = 5;
    private ColaConsulta[] cola = new ColaConsulta[CANT_COLAS];

    public ColaConsulta[] getCola() {
        return cola;
    }

    public void setCola(ColaConsulta[] cola) {
        this.cola = cola;
    }
}
