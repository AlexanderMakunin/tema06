package com.alexandermakunin.ejercicio6;

public class Bicicleta {
    private String referencia;
    private String marca;
    private String modelo;
    private int kg;
    private int tamanyo;
    private boolean motor;
    private String fecha;
    private int precio;
    private int existencias;

    public Bicicleta(String referencia, String marca, String modelo, int kg, int tamanyo, boolean motor, String fecha, int precio) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.kg = kg;
        this.tamanyo = tamanyo;
        this.motor = motor;
        this.fecha = fecha;
        this.precio = precio;
        this.existencias = 1;
    }

    public Bicicleta(String referencia, String marca, String modelo, int kg, int tamanyo, boolean motor, String fecha, int precio, int existencias) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.kg = kg;
        this.tamanyo = tamanyo;
        this.motor = motor;
        this.fecha = fecha;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "referencia='" + referencia + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", kg=" + kg +
                ", tamanyo=" + tamanyo +
                ", motor=" + motor +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                '}';
    }
}
