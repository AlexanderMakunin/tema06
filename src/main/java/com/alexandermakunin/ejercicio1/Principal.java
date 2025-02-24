package com.alexandermakunin.ejercicio1;

import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Coche coche = new Coche();
        System.out.println(coche);
        Coche macho = new Coche("Mamado","Rojo",true,Coche.TipoCoche.DEPORTIVO, LocalDateTime.now(), Coche.ModalidadSeguro.RIESGO);
        System.out.println(macho);
        for (int i = 0; i < 2417500; i++) {
            Coche adfsg = new Coche("Mamado","Rojo",true,Coche.TipoCoche.DEPORTIVO, LocalDateTime.now(), Coche.ModalidadSeguro.RIESGO);
            System.out.println(adfsg);
        }
    }
}
