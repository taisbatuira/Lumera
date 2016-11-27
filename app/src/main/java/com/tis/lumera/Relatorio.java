package com.tis.lumera;

import java.io.Serializable;

/**
 * Created by Tis on 26/11/2016.
 * DTO - Data Transfer Object
 * Classe criada apenas com getter/setter para transferir dados entre classes
 */
public class Relatorio implements Serializable{

    public String nomeLampada1;
    public int potenciaLampada1;
    public int lumensLampada1;
    public int qtdLampadas1;

    public String nomeLampada2;
    public int potenciaLampada2;
    public int lumensLampada2;
    public double precoLampada2;

    public int luxAmbiente;
    public int tamanhoAmbiente;
    public double valorKwH;
    public double horasLigada;
    public double diasLigada;

    public double reducao;
    public int qtdLampadas2;
    public double valorInstalacaoLampadas2;


    public static Relatorio novo() {
        return new Relatorio();
    }

    public Relatorio comLampada1(String nomeLampada1, int potenciaLampada1, int lumensLampada1, int qtdLampadas1) {
        this.nomeLampada1 = nomeLampada1;
        this.potenciaLampada1 = potenciaLampada1;
        this.lumensLampada1 = lumensLampada1;
        this.qtdLampadas1 = qtdLampadas1;

        return this;
    }

    public Relatorio comLampada2(String nomeLampada2, int potenciaLampada2, int lumensLampada2, double precoLampada2) {
        this.nomeLampada2 = nomeLampada2;
        this.potenciaLampada2 = potenciaLampada2;
        this.lumensLampada2 = lumensLampada2;
        this.precoLampada2 = precoLampada2;

        return this;
    }

    public Relatorio comDadosGerais(int luxAmbiente, int tamanhoAmbiente, double valorKwH, double horasLigada, double diasLigada) {
        this.luxAmbiente = luxAmbiente;
        this.tamanhoAmbiente = tamanhoAmbiente;
        this.valorKwH = valorKwH;
        this.horasLigada = horasLigada;
        this.diasLigada = diasLigada;

        return this;
    }

    public Relatorio comCalculos(double reducao, int qtdLampadas2, double valorInstalacaoLampadas2) {
        this.reducao = reducao;
        this.qtdLampadas2 = qtdLampadas2;
        this.valorInstalacaoLampadas2 = valorInstalacaoLampadas2;

        return this;
    }
}
