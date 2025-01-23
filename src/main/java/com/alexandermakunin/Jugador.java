package com.alexandermakunin;

public class Jugador {
    private final String nombre;
    private float portero;
    private float defensa;
    private float pase;
    private float regate;
    private float tiro;
    private float estadoForma;
    // Constructor
    public Jugador(String nombre, float portero, float defensa, float pase, float regate, float tiro, float
            estadoForma) {
        this.nombre = nombre;
        this.portero = portero;
        this.defensa = defensa;
        this.pase = pase;
        this.regate = regate;
        this.tiro = tiro;
        this.estadoForma = estadoForma;
    }
    // Constructor
    public Jugador(String nombre) {
        this(nombre, 50, 50, 50, 50, 50, 50);
    }
    // Resto de métodos
    @Override
    public String toString() {
        return "Jugador{" +
                "portero=" + portero +
                ", defensa=" + defensa +
                ", pase=" + pase +
                ", regate=" + regate +
                ", tiro=" + tiro +
                ", estadoForma=" + estadoForma +
                '}';
    }

}