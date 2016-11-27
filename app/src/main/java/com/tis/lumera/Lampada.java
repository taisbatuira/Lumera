package com.tis.lumera;

/**
 * Created by Tis on 14/11/2016.
 */
public class Lampada {

    private final String nomeDaLampada;
    private final int potencia;
    private final int lumen;

    public Lampada(String nomeDaLampada, int potencia, int lumen) {
        this.nomeDaLampada = nomeDaLampada;
        this.potencia = potencia;
        this.lumen = lumen;
    }

    @Override
    public String toString() {
        return String.valueOf(potencia);
    }

    public int getPotencia() {
        return potencia;
    }

    public int getLumens() {
        return lumen;
    }

    public String getNomeDaLampada() {
        return nomeDaLampada;
    }
}
