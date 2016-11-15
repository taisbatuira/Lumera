package com.tis.lumera;

/**
 * Created by Tis on 14/11/2016.
 */
public class Calculadora {
    public static double consumo (double horas, double dias, double potencia){ //metodo para e1 e e2
        double tempo = horas*dias;
        return tempo*(potencia/1000);
    }

    public static double valorConsumo(double consumo, double valorKwH){
        return consumo*valorKwH;
    }

    public static double reducao(double valorConsumo1, double valorConsumo2){
        return (valorConsumo2/valorConsumo1)*100;
    }
}
