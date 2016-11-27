package com.tis.lumera;

/**
 * Created by Tis on 26/11/2016.
 */
public class Ambiente {
    private String nome;
    private int iluminancia;

    public Ambiente(String nome, int iluminancia) {
        this.nome = nome;
        this.iluminancia = iluminancia;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public int getLux() {
        return iluminancia;
    }
}
