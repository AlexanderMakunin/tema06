package com.alexandermakunin.ejercicio1;

public class Principal {
    public static void main(String[] args) {
        Coche coche = new Coche();
        System.out.println(coche);
        Coche macho = new Coche("Mamado","Rojo",true,"M4CH0", Coche.TipoCoche.DEPORTIVO,1999, Coche.ModalidadSeguro.RIESGO);
        System.out.println(macho);
    }
}
